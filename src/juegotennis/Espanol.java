/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

/**
 *
 * @author Omar
 */
public class Espanol implements Idioma {
    
    public String getPuntos(int puntos){
        String palabras[]={"CERO","QUINCE","TREINTA","CUARENTA"};
        return palabras[puntos];
    }
    public String getDeuce(){
        return "EMPATE";
    }
    public String getAll(){
        return "IGUALES";
    }
    public String getAdvantage(){
        return "VENTAJA JUGADOR ";
    }
    public String getWin(){
        return "GANA JUGADOR ";
    }
}
