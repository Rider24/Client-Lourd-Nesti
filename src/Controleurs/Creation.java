/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.modele;

/**
 *
 * @author Elrick
 */
public class Creation {
    // Création d'un nouvel utilisateur, selon les valeurs renseignées dans le formulaire.
    public static boolean creationNouvelUtilisateur(String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            String query = "INSERT INTO `utilisateur` (`idUser`, `nomUser`, `prenom`, `ddnUser`, `adresse`, `mail`, `Droits_idDroits`, `login`, `mdp`, `CodePostal_Ville_idVille`, `CodePostal_CodePostal_cp`) "
                    + "VALUES (NULL, '"+nom+"', '"+prenom+"', '"+dateNaissance+"', '"+adresse+"', '"+mail+"', '"+droits+"', '"+login+"', '"+mdp+"', '"+idVille+"', '"+codePostal+"');";
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
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }}
}
