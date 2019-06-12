/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    // Connexion utilisateur selon Login et Mdp
    public static int validationIdentifiants(String login, String mdp){
        int reponse;
        try {
            Connection co = modele.startConnection();
            
            Statement stmt = co.createStatement();
            String query = "SELECT idUser,Droits_idDroits FROM utilisateur WHERE login='"+login+"' AND mdp='"+mdp+"'";
            
            ResultSet resultat = stmt.executeQuery(query);
            if(resultat.next()){
                int droitUser = resultat.getInt("Droits_idDroits");
                if(droitUser != 1){
                    reponse = 4;
                } else{
                    reponse = 1;
                }
            }
            else{
                reponse = 2;
            }  
            modele.closeConnection(co);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            reponse = 3;
        }       
        return reponse;
    }  
    public static String hashMotDePasse(String mdp){
        mdp = "test";
            byte[] byteChaine = null;
            try {
                byteChaine = mdp.getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            }
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Creation.class.getName()).log(Level.SEVERE, null, ex);
            }
            md.update(byteChaine);
            byte[] hash = md.digest();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println("En format hexa : " + sb.toString());
            return sb.toString();
    }
}
