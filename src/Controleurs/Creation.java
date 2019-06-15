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
public class Creation {

    // Création d'un nouvel utilisateur, selon les valeurs renseignées dans le formulaire.
    public static boolean creationUtilisateur(String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal) {
        boolean AEnvoyer;
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();

            String mpdHashé = Connexion.hashMotDePasse(mdp);
            
            String query = "INSERT INTO `utilisateur` (`idUser`, `nomUser`, `prenom`, `ddnUser`, `adresse`, `mail`, `Droits_idDroits`, `login`, `mdp`, `CodePostal_Ville_idVille`, `CodePostal_CodePostal_cp`) "
                    + "VALUES (NULL, '" + nom + "', '" + prenom + "', '" + dateNaissance + "', '" + adresse + "', '" + mail + "', '" + droits + "', '" + login + "', '" + mpdHashé + "', '" + idVille + "', '" + codePostal + "');";
            System.out.println(query);
            int retour = declaration.executeUpdate(query);

            if (retour == 1) {
                modele.closeConnection(co);
                AEnvoyer = true;
            } else {
                modele.closeConnection(co);
                AEnvoyer = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            AEnvoyer = false;
        }
        return AEnvoyer;
    }

    public static boolean ajoutIngredientRecette(int idIng, int idRec) {
        boolean renvoi = false;
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();

            String query = "INSERT INTO contenurecette (Ingredients_idIng, Recette_idRec) VALUES (" + idIng + ", " + idRec + ");";
            int retour = declaration.executeUpdate(query);
            System.out.println(retour);
            if (retour == 1) {
                renvoi = true;
            }
            modele.closeConnection(co);
        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return renvoi;
    }

    public static boolean creationRecette(String nom, String descript, String nomTheme) {
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();

            String requete = "INSERT INTO recette (idRec, nom, description, Theme_idTheme) VALUES (NULL, \"" + nom + "\", \"" + descript + "\", (SELECT idTheme FROM theme WHERE theme.descript = \""+ nomTheme + "\"))";

            int retour = declaration.executeUpdate(requete);

            if (retour == 1) {
                modele.closeConnection(co);
                return true;
            } else {
                modele.closeConnection(co);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public static boolean creationCuisinier(String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal, String specialite){        
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();

            String mpdHashé = Connexion.hashMotDePasse(mdp);
            
            
            String requete = "INSERT INTO `utilisateur` (`idUser`, `nomUser`, `prenom`, `ddnUser`, `adresse`, `mail`, `Droits_idDroits`, `login`, `mdp`, `CodePostal_Ville_idVille`, `CodePostal_CodePostal_cp`) "
                    + "VALUES (NULL, '" + nom + "', '" + prenom + "', '" + dateNaissance + "', '" + adresse + "', '" + mail + "', '" + droits + "', '" + login + "', '" + mpdHashé + "', '" + idVille + "', '" + codePostal + "');";
            System.out.println(requete);
            int retour = declaration.executeUpdate(requete);
            requete = "INSERT INTO cuisinier (idCuisinier, Specialite_idSpecialite) VALUES ((SELECT idUser FROM utilisateur WHERE nomUser = \""+nom+ "\" AND Droits_idDroits = " + droits + "),\n" +
                        "(SELECT idSpecialite FROM specialite WHERE specialite = \""+ specialite + "\"));";
            int retour2 = declaration.executeUpdate(requete);
            
            if (retour == 1 && retour2 == 1) {
                modele.closeConnection(co);
                return true;
            } else {
                modele.closeConnection(co);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean creationLieu(String nomLieu, String nomVille, int cp){
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();
                  
            String requete = "INSERT INTO `lieux` (`idLieux`, `nom`, `CodePostal_Ville_idVille`, `CodePostal_CodePostal_cp`) "
                    + "VALUES (NULL, \"" + nomLieu + "\", (SELECT idVille FROM ville WHERE ville = \"" + nomVille + "\"), " + cp +" );";
            System.out.println(requete);
            int retour = declaration.executeUpdate(requete);
            
            if (retour == 1) {
                modele.closeConnection(co);
                return true;
            } else {
                modele.closeConnection(co);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean creationHoraire(String plageHoraire){
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();
                  
            String requete = "INSERT INTO `plagehoraire` (`idPlageHoraire`, `debut`) VALUES (NULL, '"+ plageHoraire+"');";
            System.out.println(requete);
            int retour = declaration.executeUpdate(requete);
            
            if (retour == 1) {
                modele.closeConnection(co);
                return true;
            } else {
                modele.closeConnection(co);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean creationCours(String nomRecette, int idCuisinier, String nomLieu, String nomVille, String plage, int durée){
        try {
            Connection co = modele.startConnection();

            Statement declaration = co.createStatement();
            
            int idRecette = Lecture.getUneRecette(nomRecette).getID();
            String date = plage.substring(0, 4)+"-"+plage.substring(5, 7)+"-"+plage.substring(8,10);
            System.out.println(date);
            
            String requete = "INSERT INTO `cours` (`Recette_idRec`, `Cuisinier_idCuisinier`, `Lieux_idLieux`, `PlageHoraire_idPlageHoraire`, `date`, `Durée`) "
                    + "VALUES (" + idRecette + ", "+idCuisinier+", (SELECT idLieux FROM lieux WHERE nom = \""+nomLieu+"\" AND CodePostal_Ville_idVille = (SELECT idVIlle FROM ville WHERE ville = \"" + nomVille + "\")), (SELECT idPlageHoraire FROM plagehoraire WHERE debut = \""+plage+"\"), \""+date+"\", "+durée+");";
            System.out.println(requete);
            int retour = declaration.executeUpdate(requete);
            
            if (retour == 1) {
                modele.closeConnection(co);
                return true;
            } else {
                modele.closeConnection(co);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
