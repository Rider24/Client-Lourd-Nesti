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
public class Ville {
    int Id;
    String nom;
    int CodePostal;

    public Ville(int Id, String nom, int CodePostal) {
        this.Id = Id;
        this.nom = nom;
        this.CodePostal = CodePostal;
    }

    public Ville(String nom, int CodePostal) {
        this.nom = nom;
        this.CodePostal = CodePostal;
    }

    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(int CodePostal) {
        this.CodePostal = CodePostal;
    }
    
}
