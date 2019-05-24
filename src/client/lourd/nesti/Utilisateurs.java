/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.lourd.nesti;

/**
 * Classe Utilisateurs
 * @author Elrick
 */
abstract class Utilisateurs {
    protected int idUser;
    protected String nom;
    protected Droits droit;

    public Utilisateurs(int idUser, String nom, Droits droit) {
        this.idUser = idUser;
        this.nom = nom;
        this.droit = droit;
    }
    
     public String getNom(){
        return this.nom;
    }
    public Droits getDroit(){
        return this.droit;
    }
    public int getID(){
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDroit(Droits droit) {
        this.droit = droit;
    }
    public String HashageMotDePasse(){
        return "";
    }
    
    }
   
