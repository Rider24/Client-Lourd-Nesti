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
public class Destruction {
    
    /**
     *
     * @param idUser
     */
    public static void deleteUser(int idUser){
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query = "DELETE FROM `utilisateur` WHERE `utilisateur`.`idUser` = " + idUser;
            System.out.println(query);
            stmt.execute(query);            
            
        } catch (SQLException ex) {
            Logger.getLogger(Destruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Supprime l'utilisateur dont l'Id a été passé en paramètre

    /**
     *
     * @param uneRecette
     */
    public static void deleteRecette(String uneRecette){
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();
              
            String query = "DELETE FROM recette WHERE nom = \"" + uneRecette + "\"";
            stmt.execute(query); 
        } catch (SQLException ex) {
            Logger.getLogger(Destruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param idIng
     * @param idRec
     */
    public static void deleteIngredientRecette(int idIng, int idRec){
        try{
        Connection co = modele.startConnection();
            
                Statement stmt = co.createStatement();
              
            String query = "DELETE FROM contenurecette WHERE contenurecette.Ingredients_idIng = "+idIng+" AND contenurecette.Recette_idRec = "+idRec+"";
            stmt.execute(query);
        }catch (SQLException ex) {
            Logger.getLogger(Destruction.class.getName()).log(Level.SEVERE, null, ex);
    }
                
    }

    /**
     *
     * @param idCuisinier
     * @param idPLageHoraire
     * @param date
     */
    public static void deleteCours(int idCuisinier, int idPLageHoraire, String date){
        try{
        Connection co = modele.startConnection();
            
                Statement stmt = co.createStatement();
              
            String query = "DELETE FROM `cours` WHERE `cours`.`Cuisinier_idCuisinier` = " + idCuisinier + " AND `cours`.`PlageHoraire_idPlageHoraire` = " + idPLageHoraire + " AND `cours`.`date` = \"" + date +"\"";
                        System.out.println(query);
            stmt.execute(query);
        }catch (SQLException ex) {
            Logger.getLogger(Destruction.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
