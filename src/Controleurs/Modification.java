/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.modele;

/**
 *
 * @author Elrick
 */
public class Modification {

    /**
     *
     * @param idUser
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param mail
     * @param droits
     * @param login
     * @param mdp
     * @param idVille
     * @param codePostal
     * @return
     */
    public static boolean modificationClient(int idUser, String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            String query = "UPDATE utilisateur SET nomUser = \""+ nom +"\", prenom = \""+ prenom +"\", ddnUser = \""+ dateNaissance + "\", adresse = \"" + adresse + "\", mail = \"" + mail + "\", login = \""+login+"\", CodePostal_Ville_idVille = " + idVille + ", CodePostal_CodePostal_cp = " + codePostal + ", Droits_idDroits = "+droits+" WHERE utilisateur.idUser = "+idUser +";";
            System.out.println(query);
            if(!"".equals(mdp)){
                query = "UPDATE utilisateur SET nomUser = \""+ nom +"\", prenom = \""+ prenom +"\", ddnUser = \""+ dateNaissance + "\", adresse = \"" + adresse + "\", mail = \"" + mail + "\", login = \""+login+"\", mdp = \"" + mdp + "\", CodePostal_Ville_idVille = " + idVille + ", CodePostal_CodePostal_cp = " + codePostal + ", Droits_idDroits = "+droits+" WHERE utilisateur.idUser = "+idUser +";";
            }
            int retour = declaration.executeUpdate(query);
            
            if(retour == 1){
                modele.closeConnection(co);
                return true;
            }
            else{
                modele.closeConnection(co);
                return false;
            }         
        } catch (SQLException ex) {
            Logger.getLogger(Modification.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }}

    /**
     *
     * @param idRec
     * @param nomRecette
     * @param desc
     * @param nomTheme
     * @return
     */
    public static boolean modificationRecette(int idRec, String nomRecette, String desc, String nomTheme){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            String query = "UPDATE recette \n" +
                "JOIN theme ON recette.Theme_idTheme = theme.idTheme\n" +
                "SET nom = \""+nomRecette+"\", description = \"" + desc + "\", Theme_idTheme = (SELECT idTheme FROM theme WHERE theme.descript = \""+ nomTheme + "\") WHERE recette.idRec = \""+idRec+"\";";
            int retour = declaration.executeUpdate(query);

            modele.closeConnection(co);
            if(retour == 1){
                return true;
            }
            else{
                return false;
            }         
        } catch (SQLException ex) {
            Logger.getLogger(Modification.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
}

    /**
     *
     * @param idIng
     * @param idRec
     * @param quantite
     * @param unite
     * @return
     */
    public static boolean modificationIngredientsRecette(int idIng, int idRec, int quantite, String unite){
        try{

                         
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            String laVraieUnite = "";
            if(!"".equals(unite)){
                laVraieUnite = ", unite = \""+unite+"\"";
            }
            
                String query = "UPDATE contenurecette SET quantite = "+quantite+laVraieUnite+" WHERE contenurecette.Ingredients_idIng = "+idIng+" AND contenurecette.Recette_idRec = \""+idRec+"\";";
                int retour = declaration.executeUpdate(query);
                if(retour == 1){
                return true;
            }
            else{
                return false;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Modification.class.getName()).log(Level.SEVERE, null, ex);
    }
        return true;      
    } 

    /**
     *
     * @param idUser
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param mail
     * @param droits
     * @param login
     * @param mdp
     * @param idVille
     * @param codePostal
     * @param specialite
     * @return
     */
    public static boolean modificationCuisinier(int idUser, String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal, String specialite){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            String query = "UPDATE utilisateur SET nomUser = \""+ nom +"\", prenom = \""+ prenom +"\", ddnUser = \""+ dateNaissance + "\", adresse = \"" + adresse + "\", mail = \"" + mail + "\", login = \""+login+"\", CodePostal_Ville_idVille = " + idVille + ", CodePostal_CodePostal_cp = " + codePostal + ", Droits_idDroits = "+droits+" WHERE utilisateur.idUser = "+idUser +";"
                    + "UPDATE cuisinier SET Specialite_idSpecialite = (SELECT idSpecialite FROM specialite WHERE specialite = \"" + specialite + "\";";
            if(!"".equals(mdp)){
                query = "UPDATE utilisateur SET nomUser = \""+ nom +"\", prenom = \""+ prenom +"\", ddnUser = \""+ dateNaissance + "\", adresse = \"" + adresse + "\", mail = \"" + mail + "\", login = \""+login+"\", mdp = \"" + mdp + "\", CodePostal_Ville_idVille = " + idVille + ", CodePostal_CodePostal_cp = " + codePostal + ", Droits_idDroits = "+droits+" WHERE utilisateur.idUser = "+idUser +";";
            }
            int retour = declaration.executeUpdate(query);
            
            if(retour == 1){
                modele.closeConnection(co);
                return true;
            }
            else{
                modele.closeConnection(co);
                return false;
            }         
        } catch (SQLException ex) {
            Logger.getLogger(Modification.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
        
    }

    /**
     *
     * @param idRec
     * @param idCuis
     * @param nomLieu
     * @param idPlage
     * @param date
     * @param durée
     * @param ancienCuis
     * @param ancienPlage
     * @param ancienDate
     * @return
     */
    public static boolean modificationCours(int idRec, int idCuis, String nomLieu, int idPlage, String date, int durée, int ancienCuis, int ancienPlage, String ancienDate){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            
            String query = "UPDATE `cours` SET `Recette_idRec` = " + idRec +", \n" +
                            "`Cuisinier_idCuisinier` = " + idCuis + ",\n" +
                            "`Lieux_idLieux` = (SELECT idLieux FROM lieux WHERE nom =  \"" + nomLieu +"\"), \n" +
                            "`PlageHoraire_idPlageHoraire` = " + idPlage + ", \n" +
                            "`date` = \"" + date +"\", \n" +
                            "`Durée` = " + durée +"\n" +
                            "WHERE `cours`.`Cuisinier_idCuisinier` = " + ancienCuis + " \n" +
                            "AND `cours`.`PlageHoraire_idPlageHoraire` = " + ancienPlage + " \n" +
                            "AND `cours`.`date` = \"" + ancienDate +"\";";
            System.out.println(query);
            int retour = declaration.executeUpdate(query);
            
            if(retour == 1){
                modele.closeConnection(co);
                return true;
            }
            else{
                modele.closeConnection(co);
                return false;
            }         
        } catch (SQLException ex) {
            Logger.getLogger(Modification.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
    }
}
