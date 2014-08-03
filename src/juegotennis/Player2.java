/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.KeyEvent;


public class Player2 extends Player {
    
    public Player2(Juego juego) {
        super(juego);
        posicionEnX = juego.getWidth() - WIDTH;
        posicionEnY = juego.getHeight() - HEIGHT*2;
    }
    public void move(){
        if (posicionEnY + movimientoEnY > 0 && posicionEnY + movimientoEnY < juego.getHeight()- HEIGHT)
			posicionEnY +=  movimientoEnY;
        if (posicionEnX + movimientoEnX > juego.getWidth()/2 && posicionEnX + movimientoEnX <= juego.getWidth()- WIDTH)
			posicionEnX += movimientoEnX;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
                movimientoEnY = -velocidad;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
                movimientoEnY = velocidad;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
                movimientoEnX = -velocidad;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                movimientoEnX = velocidad;
        if (e.getKeyCode() == KeyEvent.VK_L)
                pegar = true;
    }
    public void reset(){
        posicionEnX = juego.getWidth() - WIDTH;
        posicionEnY = juego.getHeight() - 80;
    }
}
