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
public class Themes {
    protected int ID;
    protected String nom;
    
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.nom;
    }
    public void setName(String name){
        this.nom = name;
    }
}
