/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

/**
 *
 * @author Omar
 */
public class English implements Idioma {
    
    public String getPuntos(int puntos){
        String palabras[]={"LOVE","FIFTEEN","THIRTY","FORTY"};
        return palabras[puntos];
    }
    public String getDeuce(){
        return "DEUCE";
    }
    public String getAll(){
        return "ALL";
    }
    public String getAdvantage(){
        return "ADVANTAGE PLAYER ";
    }
    public String getWin(){
        return "WINS PLAYER ";
    }
}
