/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import modele.modele;

/**
 *
 * @author Elrick
 */
public class Connexion {
    
    public static boolean validationIdentifiants(JTextField jTextField1, JTextField jTextField2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Connexion utilisateur selon Login et Mdp
    public static int validationIdentifiants(String login, String mdp){
        try {
            Connection co = modele.startConnection();
            
            Statement stmt = co.createStatement();
            String query = "SELECT idUser,Droits_idDroits FROM utilisateur WHERE login='"+login+"' AND mdp='"+mdp+"'";
            
            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                modele.closeConnection(co);
                return 1;
            }
            else{
                modele.closeConnection(co);
                return 2;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return 3;
        }
    }
    private boolean checkAdmin(int identifiant){
        
        return false;
        
    }    
    }
