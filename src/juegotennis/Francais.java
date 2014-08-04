/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

/**
 *
 * @author Omar
 */
public class Francais implements Idioma {
    
    public String getPuntos(int puntos){
        String palabras[]={"ZERO","QUINZE","TRENTE","QUARANTE"};
        return palabras[puntos];
    }
    public String getDeuce(){
        return "ATTACHER";
    }
    public String getAll(){
        return "À";
    }
    public String getAdvantage(){
        return "AVANTAGE JOUEUR ";
    }
    public String getWin(){
        return "GAGNE JOUEUR ";
    }
}
