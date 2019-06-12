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
public class Cours {

    private String lieu;
    private Ville ville;
    private String nomrecette;
    private String date;
    private String cuisinier;
    private int durée;

    public Cours(String lieu, Ville ville, String nomrecette, String date, String cuisinier, int durée) {
        this.lieu = lieu;
        this.ville = ville;
        this.nomrecette = nomrecette;
        this.date = date;
        this.cuisinier = cuisinier;
        this.durée = durée;
    }

    public int getDurée() {
        return durée;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String getNomrecette() {
        return nomrecette;
    }

    public void setNomrecette(String nomrecette) {
        this.nomrecette = nomrecette;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCuisinier() {
        return cuisinier;
    }

    public void setCuisinier(String cuisinier) {
        this.cuisinier = cuisinier;
    }
    
    
}
