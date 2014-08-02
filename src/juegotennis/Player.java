/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Omar
 */
abstract class Player {

	static final int WIDTH = 10;
	static final int HEIGHT = 60;
	int posicionEnY = 0;
	int movimientoEnY = 0;
        int posicionEnX = 0;
        int movimientoEnX = 0;
        int velocidad = 2;
        boolean pegar = false;
	public Juego juego;

	public Player(Juego juego) {
		this.juego = juego;
	}

	public abstract void move();

	public void paint(Graphics2D g) {
		g.fillRect(posicionEnX, posicionEnY, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		movimientoEnY = 0;
                movimientoEnX = 0;
                pegar = false;
	}

	public Rectangle getBounds() {
		return new Rectangle(posicionEnX, posicionEnY, WIDTH, HEIGHT);
	}
}
