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
public class Cuisiniers extends Utilisateurs{
    private Specialites spe;

    public Cuisiniers(Specialites spe, int idUser, String nom, Droits droit, String prenom, String adresse, String mail, String ddn, String login, String ville, int codePostal) {
        super(idUser, nom, droit, prenom, adresse, mail, ddn, login, ville, codePostal);
        this.spe = spe;
    }

    
    public Specialites getSpe() {
        return spe;
    }
    public void setSpe(Specialites spe) {
        this.spe = spe;
    }
}
