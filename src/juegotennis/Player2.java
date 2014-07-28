/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.KeyEvent;


public class Player2 extends Player {
    int posicionEnX;
    public Player2(Juego juego,int posicionEnX) {
        super(juego);
        this.posicionEnX =  posicionEnX;
    }
    int getPosicionEnX() {
        return posicionEnX;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
                moverse(-1);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
                moverse(1);
    }
}
