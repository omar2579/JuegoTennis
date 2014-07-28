/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.KeyEvent;


public class Player1 extends Player {
    int posicionEnX;
    public Player1(Juego juego,int posicionEnX) {
        super(juego);
        this.posicionEnX =  posicionEnX;
    }
    public int getPosicionEnX(){
        return posicionEnX;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
                moverse(-1);
        if (e.getKeyCode() == KeyEvent.VK_Z)
                moverse(1);
    }
}
