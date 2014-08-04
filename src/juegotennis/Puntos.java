/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegotennis;

/**
 *
 * @author Omar
 */
public class Puntos {
    
    int puntosPlayer1, puntosPlayer2;
    String nombrePlayer1, nombrePlayer2;
    Idioma idioma = new Espanol();
    
    void setPuntos(int player){
        if(player == 1)
            puntosPlayer1++;
        else
            puntosPlayer2++;
    }
    String score(){
        if(puntosPlayer1<3 && puntosPlayer1==puntosPlayer2){
            return idioma.getPuntos(puntosPlayer1)+" - "+idioma.getAll();
        }
        if(puntosPlayer1>2 && puntosPlayer1==puntosPlayer2){
            puntosPlayer1=3;puntosPlayer2=3;
            return idioma.getDeuce();
        }
        if(puntosPlayer1==4 && puntosPlayer2 == 3){
            return idioma.getAdvantage()+" "+nombrePlayer1;
        }
        if(puntosPlayer1==3 && puntosPlayer2 == 4){
            return idioma.getAdvantage()+" "+nombrePlayer2;
        }
        if(puntosPlayer1==5 || (puntosPlayer1==4 && puntosPlayer2 <3)){
            return idioma.getWin()+" "+nombrePlayer1;
        }
        if(puntosPlayer2==5 || (puntosPlayer1<3 && puntosPlayer2 ==4)){
            return idioma.getWin()+" "+nombrePlayer2;
        }
        else    
            return idioma.getPuntos(puntosPlayer1)+" - "+idioma.getPuntos(puntosPlayer2);
    }
    
    void setNombreJugador(int player, String nombre){
        if(player == 1){
            nombrePlayer1=nombre;
        }
        else{
            nombrePlayer2=nombre;
        }
    }
    
    void setIdioma(Idioma idioma){
        this.idioma = idioma;
    }
}
