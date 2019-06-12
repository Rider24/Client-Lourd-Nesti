/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import java.io.UnsupportedEncodingException;
import java.security.*;
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
    public static boolean creationNouvelUtilisateur(String nom, String prenom, String dateNaissance, String adresse, String mail, int droits, String login, String mdp, int idVille, int codePostal) {
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

}
