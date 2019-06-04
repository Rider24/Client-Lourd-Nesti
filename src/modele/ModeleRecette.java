/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import client.lourd.nesti.Recettes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elrick
 */
public class ModeleRecette {
    
    public static void createRecipe(String nom){
        try {
            Connection co = modele.startConnection();
            
            Statement declaration = co.createStatement();
            
            String query = "INSERT INTO recette (Nom) VALUES ('" + nom + "')";
            System.out.println(query);
            
            
            int retour = declaration.executeUpdate(query);
            
            if(retour == 1){
                System.out.println("Insertion dans recettes réussie");
            }
            else{
                System.err.println("Insertion Echouée");
            }
            
            modele.closeConnection(co);
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // CREATE
    
    public static void readRecipeById(int id){
        
        try {
            Connection co = modele.startConnection();
            
            Statement stmt = co.createStatement(); 
            String query = "Select * from recette where id = "+ id;
            
            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                System.out.println("Recette : ");
                String nom = resultat.getString("nom");
                String un = resultat.getString(1);
                System.out.println(nom + " " + un);
            }
            
            modele.closeConnection(co);
        } 
        catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // READ(ALL)
            
//    public static void readAllRecipes(){
//        try {
//            Connection co = modele.startConnection();
//            
//            Statement smts = co.createStatement();
//            String query = "Select * from recette";
//            try (ResultSet resultats = smts.executeQuery(query)) {
//                while(resultats.next()){
//                    Recettes r = new Recettes();
//                    r.setName(resultats.getString("nom"));
//                    r.setId(resultats.getInt("id"));
//                    System.out.println(r.toString());
//                    
//                    
//                    
//                    
//                    
////                System.out.println("resultat : ");
////                String nom = resultats.getString("nom");
////                int id = resultats.getInt("id"); 
////                System.out.println(id + " " +nom);
//                }
//            }
//            modele.closeConnection(co);
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
//        }} // READ

    public static void modifyRecipe(int id, String nom){
        try {
            Connection co = modele.startConnection();
            
            Statement smts = co.createStatement();
            String query = "UPDATE `recette` SET `Id` = '"+id+"', `Nom` = '"+nom+"' WHERE `recette`.`Id` = "+id+";";
            smts.execute(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }} // UPDATE
    
    public static void deleteRecipe(int id){
        try {
            Connection co = modele.startConnection();
            
            Statement smts = co.createStatement();
            String query = "DELETE FROM `recette` WHERE `recette`.`Id` = "+id;
            smts.execute(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }} // DELETE
    }