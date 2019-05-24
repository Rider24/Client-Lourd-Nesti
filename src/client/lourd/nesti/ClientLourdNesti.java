/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.lourd.nesti;
import java.sql.Connection;

/**
 *
 * @author Elrick
 */
public class ClientLourdNesti {
    
    public static void main(String[] args) {
        //
        
//        for(int i = 0; i<3; i++){
//           
//            modele.ModeleRecette.createRecipe("recette numéro " + i);
//        }
        // modele.ModeleRecette.createRecipe("crepes");
        // modele.ModeleRecette.readRecipeById(1);
        // modele.ModeleRecette.readAllRecipes();
//        modele.ModeleRecette.modifyRecipe(8, "coucou");
        modele.ModeleRecette.deleteRecipe(4);
    }
    
    }
