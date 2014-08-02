/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.KeyEvent;


public class Player2 extends Player {
    
    public Player2(Juego juego) {
        super(juego);
        this.posicionEnX =  juego.getWidth() - WIDTH;
    }
    public void move(){
        if (posicionEnY + movimientoEnY > 0 && posicionEnY + movimientoEnY < juego.getHeight()- HEIGHT)
			posicionEnY +=  movimientoEnY;
        if (posicionEnX + movimientoEnX > juego.getWidth()/2 && posicionEnX + movimientoEnX < juego.getWidth()- WIDTH)
			posicionEnX += movimientoEnX;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
                movimientoEnY = -1;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
                movimientoEnY = 1;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
                movimientoEnX = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                movimientoEnX = 1;
    }
}
