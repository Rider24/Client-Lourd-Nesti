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
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVilles;
    }
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
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeleRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVilles;    
    }
}
