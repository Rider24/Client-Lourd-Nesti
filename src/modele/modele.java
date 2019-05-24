/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elrick
 */
public class modele {
    
    public static Connection startConnection(){
        
        String url = "jdbc:mysql://127.0.0.1/nesti";
        String user = "root";
        String password = "";
        Connection co = null;
        
        try {
            co = DriverManager.getConnection(url, user, password);
            if(!co.isClosed()){
                System.out.println("Connexion OK !");
            }
            else{
                System.out.println("pas de connexion.");
            }
        }
        catch (SQLException ex){
            System.err.println("Exception : " + ex.getMessage());
            Logger.getLogger(modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return co;
    }
    
    public static void closeConnection(Connection co){
        if(co != null){
            try {
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(modele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
