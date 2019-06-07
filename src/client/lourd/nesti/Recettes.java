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
    protected Ingredients ingredients;

    public Recettes(int ID, String nom, String description) {
        this.ID = ID;
        this.nom = nom;
        this.description = description;
    }

    
    public Recettes(int ID, String nom, Themes theme, String description) {
        this.ID = ID;
        this.nom = nom;
        this.theme = theme;
        this.description = description;
    }

    public Recettes(int ID, String nom, Themes theme, String description, Ingredients ingredients) {
        this.ID = ID;
        this.nom = nom;
        this.theme = theme;
        this.description = description;
        this.ingredients = ingredients;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Themes getTheme() {
        return theme;
    }

    public void setTheme(Themes theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Recettes{" + "ID=" + ID + ", nom=" + nom + '}';
    }
}
