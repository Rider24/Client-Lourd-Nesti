/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import client.lourd.nesti.Ville;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.ModeleRecette;
import modele.modele;

/**
 *
 * @author Elrick
 */
public class Destruction {
    
    public static void deleteUser(int idUser){
        try {
            Connection co = modele.startConnection();

            Statement stmt = co.createStatement();

            String query = "DELETE FROM `utilisateur` WHERE `utilisateur`.`idUser` = " + idUser;
            System.out.println(query);
            stmt.execute(query);            
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
