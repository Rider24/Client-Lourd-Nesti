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
    protected String prenom;
    protected String adresse;
    protected String mail;
    protected String ddn;
    protected String login;
    protected String ville;
    protected int codePostal;

    public Utilisateurs(int idUser, String nom, Droits droit, String prenom, String adresse, String mail, String ddn, String login, String ville, int codePostal) {
        this.idUser = idUser;
        this.nom = nom;
        this.droit = droit;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.ddn = ddn;
        this.login = login;
        this.ville = ville;
        this.codePostal = codePostal;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDdn() {
        return ddn;
    }

    public void setDdn(String ddn) {
        this.ddn = ddn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    
    public String HashageMotDePasse(){
        return "";
    }
    
    }
   
