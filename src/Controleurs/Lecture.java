/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import client.lourd.nesti.Categories;
import client.lourd.nesti.Clients;
import client.lourd.nesti.Cours;
import client.lourd.nesti.Cuisiniers;
import client.lourd.nesti.Droits;
import client.lourd.nesti.Ingredients;
import client.lourd.nesti.Lieux;
import client.lourd.nesti.PlageHoraires;
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
            
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
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
            else{
                unClient = null;
            }
            modele.closeConnection(co);   
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unClient;
    } // renvoie un utilisateur de type Client
    public static ArrayList getLesRecettesSelonTheme(String nomTheme){
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
        
    } // Attrape les recettes de la base selon le thème
    public static ArrayList getLesRecettes(){
        ArrayList<Recettes> lesRecettes = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "select idRec, nom, description, theme.idTheme, theme.descript from recette join theme on recette.Theme_idTheme = theme.idTheme";
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
    } // Récupère les recettes de la BDD
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
    public static ArrayList getLesCategories(){
        ArrayList<Categories> lesCategories = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "select * from categorie";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Categories uneCategorie = new Categories(resultat.getInt("idCategorie"), resultat.getString("categorie"));
                    lesCategories.add(uneCategorie);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesCategories = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCategories;
    } // Récupère les categories de ma BDD
    public static ArrayList getLesIngredientsSelonCategorie(String categorie){
        ArrayList<Ingredients> lesIngredients = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "select * from ingredients where Categorie_idCategorie = (SELECT idCategorie FROM categorie WHERE categorie = \"" + categorie + "\")";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Ingredients ingredient = new Ingredients(resultat.getInt("idIng"), resultat.getString("nom"));
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
    }
    public static ArrayList getLesCuisiniers(){
        ArrayList<Cuisiniers> lesCuisiniers = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT DISTINCT idUser, nomUser, prenom, ddnUser, adresse, mail, login, CodePostal_CodePostal_cp, ville.ville, specialite.idSpecialite, specialite.specialite FROM utilisateur\n" +
                            "join ville on utilisateur.CodePostal_Ville_idVille = ville.idVille\n" +
                            "JOIN cuisinier ON utilisateur.idUser = cuisinier.idCuisinier\n" +
                            "JOIN specialite ON cuisinier.Specialite_idSpecialite = specialite.idSpecialite\n" +
                            "WHERE utilisateur.Droits_idDroits = 3";
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
                    Specialites spe = new Specialites(resultat.getInt("specialite.idSpecialite"), resultat.getString("specialite.specialite"));
                    Cuisiniers cuisinier = new Cuisiniers(spe, idUser, nom, droit, prenom, adresse, mail, ddn, login, ville, codePostal);
                    lesCuisiniers.add(cuisinier);
                }
                while(resultat.next());
                modele.closeConnection(co);                
            }
            else{
                lesCuisiniers = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCuisiniers;
    } // Récupère les cuisiniers de la BDD
    public static Cuisiniers getUnCuisinier(int ID){
        Cuisiniers unCuisinier = null;
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT DISTINCT idUser, nomUser, prenom, ddnUser, adresse, mail, login, CodePostal_CodePostal_cp, ville.ville, droits.idDroits, droits.nomDroits, specialite.idSpecialite, specialite.specialite FROM utilisateur\n" +
                            "join ville on utilisateur.CodePostal_Ville_idVille = ville.idVille\n" +
                            "join droits on utilisateur.Droits_idDroits = droits.idDroits\n" +
                            "JOIN cuisinier ON utilisateur.idUser = cuisinier.idCuisinier " +
                            "JOIN specialite ON cuisinier.Specialite_idSpecialite = specialite.idSpecialite " +
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
                    Droits droit = new Droits(3, "Cuisinier");
                    Specialites spe = new Specialites(resultat.getInt("idSpecialite"), resultat.getString("specialite"));
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
    public static ArrayList getLesIngredients(){
        ArrayList<Ingredients> lesIngredients = new ArrayList<>();
        
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query =  "SELECT idIng, nom FROM ingredients";
            ResultSet resultat = stmt.executeQuery(query);
            if (resultat.next()) {
                do {             
                    Ingredients ingredient = new Ingredients(resultat.getInt("idIng"), resultat.getString("nom"));
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
    } // Renvoie un tableau contenant tous les ingredients.
    public static ArrayList getLesCours(){
        ArrayList<Cours> lesCours = new ArrayList<>();
        
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();
            
            String query = "SELECT DISTINCT Durée, lieux.nom, lieux.CodePostal_CodePostal_cp, recette.nom, plagehoraire.debut, ville.ville, ville.idVille, utilisateur.nomUser FROM cours\n" +
"JOIN lieux ON cours.Lieux_idLieux = lieux.idLieux\n" +
"JOIN recette ON cours.Recette_idRec = recette.idRec\n" +
"JOIN plagehoraire ON cours.PlageHoraire_idPlageHoraire = plagehoraire.idPlageHoraire\n" +
"JOIN ville ON lieux.CodePostal_Ville_idVille = ville.idVille\n" +
"JOIN cuisinier ON cours.Cuisinier_idCuisinier = cuisinier.idCuisinier\n" +
"JOIN utilisateur ON cuisinier.idCuisinier = utilisateur.idUser";
            
            System.out.println(query);
            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                do {       
                    String nomDuLieu = resultat.getString("lieux.nom");
                    Ville ville = new Ville(resultat.getInt("ville.idVille"), resultat.getString("ville.ville"), resultat.getInt("lieux.CodePostal_CodePostal_cp"));
                    String nomRecette = resultat.getString("recette.nom");
                    String date = resultat.getString("plagehoraire.debut");
                    int durée = resultat.getInt("Durée");
                    String nomCuisinier = resultat.getString("utilisateur.nomUser");
                    Cours cours = new Cours(nomDuLieu, ville, nomRecette,date, nomCuisinier, durée);
                    lesCours.add(cours);
                }
                while(resultat.next());
                modele.closeConnection(co);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCours;
    } // Récupère tous les cours de la base de donnée
    public static ArrayList getLesPlagesHoraires(){
        ArrayList<PlageHoraires> lesPlages = new ArrayList<>();
        
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();
            
            String query = "SELECT idPlageHoraire, debut from plagehoraire";
            
            System.out.println(query);
            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                do {       
                    int idPlage = resultat.getInt("idPlageHoraire");
                    String durée = resultat.getString("debut");
                    
                    PlageHoraires unePlage = new PlageHoraires(idPlage, durée);
                    lesPlages.add(unePlage);
                }
                while(resultat.next());
                modele.closeConnection(co);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPlages;
    } // Récupère les plages horaires de la table.
    public static ArrayList getLesLieux(){
        ArrayList<Lieux> lesLieux = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();
            
            String query = "SELECT idLieux, nom, ville.ville, CodePostal_CodePostal_cp, CodePostal_Ville_idVille FROM lieux JOIN ville ON lieux.CodePostal_Ville_idVille = ville.idVille";

            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                do {       
                    int idLieux = resultat.getInt("idLieux");
                    String nomLieux = resultat.getString("nom");
                    Ville uneVille = new Ville(resultat.getInt("CodePostal_Ville_idVille"),resultat.getString("ville.ville"), resultat.getInt("CodePostal_CodePostal_cp"));
                    Lieux unLieu = new Lieux(idLieux, nomLieux, uneVille);
                    lesLieux.add(unLieu);
                }
                while(resultat.next());
                modele.closeConnection(co);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesLieux;
    }// Récupère les lieux de la base de donnée
    public static ArrayList getLesSpecialités(){
        ArrayList<Specialites> lesSpe = new ArrayList<>();
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();
            
            String query = "SELECT * FROM specialite";

            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                do {       
                    int idSpe = resultat.getInt("idSpecialite");
                    String nomSpe = resultat.getString("specialite");
                    Specialites uneSpe = new Specialites(idSpe, nomSpe);
                    lesSpe.add(uneSpe);
                }
                while(resultat.next());
                modele.closeConnection(co);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesSpe;
    }// Recupere les spécialités de la BDD.
}
