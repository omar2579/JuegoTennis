/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.KeyEvent;


public class Player1 extends Player {

    public Player1(Juego juego) {
        super(juego);
        posicionEnX =  0;
        posicionEnY =  30;
    }
    public void move(){
        if (posicionEnY + movimientoEnY > 0 && posicionEnY + movimientoEnY < juego.getHeight()- HEIGHT)
			posicionEnY +=  movimientoEnY;
        if (posicionEnX + movimientoEnX > 0 && posicionEnX + movimientoEnX < (juego.getWidth()/2)- WIDTH)
			posicionEnX += movimientoEnX;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
                movimientoEnY = -velocidad;
        if (e.getKeyCode() == KeyEvent.VK_S)
                movimientoEnY = velocidad;
        if (e.getKeyCode() == KeyEvent.VK_A)
                movimientoEnX = -velocidad;
        if (e.getKeyCode() == KeyEvent.VK_D)
                movimientoEnX = velocidad;
        if (e.getKeyCode() == KeyEvent.VK_E)
                pegar = true;
    }
    public void reset(){
        posicionEnX =  0;
        posicionEnY =  30;
    }
}
