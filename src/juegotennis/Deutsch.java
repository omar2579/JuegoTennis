/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

/**
 *
 * @author Omar
 */
public class Deutsch implements Idioma{
    
    public String getPuntos(int puntos){
        String palabras[]={"LIEBE","FÜNZEHN","DREBIG","VIERZING"};
        return palabras[puntos];
    }
    public String getDeuce(){
        return "ZIEHEN";
    }
    public String getAll(){
        return "ALLE";
    }
    public String getAdvantage(){
        return "SPIELER BEWEGT SICH ";
    }
    public String getWin(){
        return "SPIELER GEWINNT ";
    }  
}
