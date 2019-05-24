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
public class Recettes{
    protected int ID;
    protected String nom;
    protected Themes theme;
    
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.nom;
    }
    public Themes getTheme(){
        return this.theme;
    }
    public void setId(int Id){
        this.ID = Id;
    }
    public void setName(String name){
        this.nom = name;
    }

    @Override
    public String toString() {
        return "Recettes{" + "ID=" + ID + ", nom=" + nom + '}';
    }
}
