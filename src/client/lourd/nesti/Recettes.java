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
    protected String description;

    public Recettes(int ID, String nom, Themes theme, String description) {
        this.ID = ID;
        this.nom = nom;
        this.theme = theme;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
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
