/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import client.lourd.nesti.Clients;
import client.lourd.nesti.Cuisiniers;
import client.lourd.nesti.Droits;
import client.lourd.nesti.Ingredients;
import client.lourd.nesti.Recettes;
import client.lourd.nesti.Specialites;
import client.lourd.nesti.Themes;
import client.lourd.nesti.Ville;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.ModeleRecette;
import modele.modele;

/**
 *
 * @author Elrick
 */
public class Lecture {

    public static ArrayList getLesVilles() {
        ArrayList<Ville> lesVilles = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query = "Select * from ville";
            ResultSet resultat = stmt.executeQuery(query);            
            if (resultat.next()) {
                do {
                    String nom = resultat.getString("ville");
                    int id = resultat.getInt("idVille");
                    Ville ville = new Ville(id, nom, 0);
                    lesVilles.add(ville);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesVilles = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVilles;
    }// Recupère toutes les villes depuis la base de données
    public static ArrayList getLesCP(String nomVille){
        ArrayList<Ville> lesVilles = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query = "select * from ville join codepostal on ville.idVille = codepostal.Ville_idVille WHERE ville = '"+nomVille+"'";
            ResultSet resultat = stmt.executeQuery(query);            
            if (resultat.next()) {
                do {
                    String nom = resultat.getString("ville");
                    int id = resultat.getInt("idVille");
                    int cp = resultat.getInt("CodePostal_cp");
                    Ville ville = new Ville(id, nom, cp);
                    lesVilles.add(ville);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesVilles = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVilles;    
    }// Récupère les codes postaux selon la ville renseignée.
    public static ArrayList getLesUtilisateur(){
        ArrayList<Clients> lesClients = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT DISTINCT idUser, nomUser, prenom, ddnUser, adresse, mail, login, CodePostal_CodePostal_cp, ville.ville, droits.idDroits, droits.nomDroits FROM `utilisateur`\n" +
                            "LEFT join ville on utilisateur.CodePostal_Ville_idVille = ville.idVille\n" +
                            "LEFT join droits on utilisateur.Droits_idDroits = droits.idDroits";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {
                    String nom = resultat.getString("nomUser");
                    String prenom = resultat.getString("prenom");
                    int idUser = resultat.getInt("idUser");
                    String ddn = resultat.getString("ddnUser");
                    String adresse = resultat.getString("adresse");
                    String mail = resultat.getString("mail");
                    String login = resultat.getString("login");
                    String ville = resultat.getString("ville.ville");
                    int codePostal = resultat.getInt("CodePostal_CodePostal_cp");
                    Droits droit = new Droits(resultat.getInt("droits.idDroits"), resultat.getString("droits.nomDroits"));
                    Clients client = new Clients(idUser, nom, droit, prenom, adresse, mail, ddn, login, ville, codePostal);
                    lesClients.add(client);
                    System.out.println(client);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesClients = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesClients;
    }  // Recupère les utilisateurs de la base de donnée
    public static Clients   getUnUtilisateur(int ID){
        Clients unClient = null;
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT DISTINCT idUser, nomUser, prenom, ddnUser, adresse, mail, login, CodePostal_CodePostal_cp, ville.ville, droits.idDroits, droits.nomDroits FROM `utilisateur`\n" +
                            "LEFT join ville on utilisateur.CodePostal_Ville_idVille = ville.idVille\n" +
                            "LEFT join droits on utilisateur.Droits_idDroits = droits.idDroits\n" + 
                            "WHERE idUser = " + ID;
            System.out.println(query);
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {
                    String nom = resultat.getString("nomUser");
                    String prenom = resultat.getString("prenom");
                    int idUser = resultat.getInt("idUser");
                    String ddn = resultat.getString("ddnUser");
                    String adresse = resultat.getString("adresse");
                    String mail = resultat.getString("mail");
                    String login = resultat.getString("login");
                    String ville = resultat.getString("ville.ville");
                    int codePostal = resultat.getInt("CodePostal_CodePostal_cp");
                    Droits droit = new Droits(resultat.getInt("droits.idDroits"), resultat.getString("droits.nomDroits"));
                    unClient = new Clients(idUser, nom, droit, prenom, adresse, mail, ddn, login, ville, codePostal);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                unClient = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unClient;
    } // renvoie un utilisateur de type Client
    public static ArrayList getLesRecettes(String nomTheme){
        ArrayList<Recettes> lesRecettes = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "select idRec, nom, description, theme.idTheme, theme.descript from recette join theme on recette.Theme_idTheme = theme.idTheme where theme.descript = '"+ nomTheme +"'";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Themes theme = new Themes(resultat.getInt("theme.idTheme"), resultat.getString("theme.descript"));
                    Recettes recette = new Recettes(resultat.getInt("idRec"), resultat.getString("nom"), theme, resultat.getString("description"));
                    lesRecettes.add(recette);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesRecettes = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesRecettes;
        
    } // Attrape les recettes de la base 
    public static ArrayList getLesThemes(){
        ArrayList<Themes> lesThemes = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "select * from theme";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Themes theme = new Themes(resultat.getInt("theme.idTheme"), resultat.getString("theme.descript"));
                    lesThemes.add(theme);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesThemes = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesThemes;
    } // Récupère les themes.
    public static Recettes  getUneRecette( String nomRecette){
        Recettes laRecette = null;
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT idRec, nom, description from recette WHERE nom = \""+ nomRecette +"\"";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {          
                    laRecette = new Recettes(resultat.getInt("idRec"), resultat.getString("nom"), resultat.getString("description"));
                modele.closeConnection(co);      
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laRecette;
    } // Renvoie le nom et la description correspondants a la recette passée en paramètre
    public static ArrayList getLesIngredientsDeUneRecette(String nomRecette){
        ArrayList<Ingredients> lesIngredients= new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT Ingredients_idIng, ingredients.nom, quantite, unite "
                    + "FROM contenurecette JOIN recette ON contenurecette.Recette_idRec = recette.idRec "
                    + "JOIN ingredients ON contenurecette.Ingredients_idIng = ingredients.idIng WHERE recette.nom = \""+nomRecette+"\"";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Ingredients ingredient = new Ingredients(resultat.getInt("Ingredients_idIng"), resultat.getString("ingredients.nom"), resultat.getInt("quantite"), resultat.getString("unite"));
                    lesIngredients.add(ingredient);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesIngredients = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesIngredients;
    }// Renvoie un tableau contenant les ingredients necessaires a la recette passée en paramètre.
    public static Cuisiniers getUnCuisinier(int ID){
        Cuisiniers unCuisinier = null;
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT DISTINCT idUser, nomUser, prenom, ddnUser, adresse, mail, login, CodePostal_CodePostal_cp, ville.ville, droits.idDroits, droits.nomDroits FROM `utilisateur`\n" +
                            "LEFT join ville on utilisateur.CodePostal_Ville_idVille = ville.idVille\n" +
                            "LEFT join droits on utilisateur.Droits_idDroits = droits.idDroits" + 
                            "WHERE idUser = " + ID;
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {
                    String nom = resultat.getString("nomUser");
                    String prenom = resultat.getString("prenom");
                    int idUser = resultat.getInt("idUser");
                    String ddn = resultat.getString("ddnUser");
                    String adresse = resultat.getString("adresse");
                    String mail = resultat.getString("mail");
                    String login = resultat.getString("login");
                    String ville = resultat.getString("ville.ville");
                    int codePostal = resultat.getInt("CodePostal_CodePostal_cp");
                    Droits droit = new Droits(3, "Cuisinier");
                    Specialites spe = new Specialites(resultat.getInt("truc"), resultat.getString("coucou"));
                    unCuisinier = new Cuisiniers(spe, idUser, nom, droit, prenom, adresse, mail, ddn, login, ville, codePostal);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                unCuisinier = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unCuisinier;
    } // Récupère un cuisinier, non fonctionnel.
}
