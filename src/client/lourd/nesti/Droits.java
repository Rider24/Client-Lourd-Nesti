/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.lourd.nesti;

/**
 *
 * @author Elrick
 */
public class Droits {
    private int ID;
    private String nom;
    
    public Droits(int Identifiant, String name){
        this.ID = Identifiant;
        this.nom = name;
    }
    public int getID(){
        return this.ID;
}
    public String getNom(){
        return this.nom;
    }
}
