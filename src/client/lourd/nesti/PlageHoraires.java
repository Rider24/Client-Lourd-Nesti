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
public class PlageHoraires {
    private int ID;
    private String date;

    public PlageHoraires(int ID, String date) {
        this.ID = ID;
        this.date = date;
    }
    
    public int getID(){
        return this.ID;
    }
    public String getDate(){
        return this.date;
    }
}
