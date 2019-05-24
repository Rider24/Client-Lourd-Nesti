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

    public Cuisiniers(Specialites spe, int idUser, String nom, Droits droit) {
        super(idUser, nom, droit);
        this.spe = spe;
    }
    public Specialites getSpe() {
        return spe;
    }
    public void setSpe(Specialites spe) {
        this.spe = spe;
    }
}
