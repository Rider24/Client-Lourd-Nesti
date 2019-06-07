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
public class Ingredients {
    protected int id;
    protected String nom;
    protected int quantite;
    protected String unite;

    public Ingredients(int id, String nom, int quantite, String unite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
}
