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

	private static final int WIDTH = 10;
	private static final int HEIGHT = 60;
	int posicionEnY = 150;
	int movimientoEnY = 0;
	private Juego juego;

	public Player(Juego juego) {
		this.juego = juego;
	}

	public void move() {
		if (posicionEnY + movimientoEnY > 0 && posicionEnY + movimientoEnY < juego.getHeight()- HEIGHT)
			posicionEnY = posicionEnY + movimientoEnY;
	}

	public void paint(Graphics2D g) {
		g.fillRect(getPosicionEnX(), posicionEnY, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		movimientoEnY = 0;
	}

	public void moverse(int movimientoEnY) {
		this.movimientoEnY = movimientoEnY;
	}

	public Rectangle getBounds() {
		return new Rectangle(getPosicionEnX(), posicionEnY, WIDTH, HEIGHT);
	}

	public int getTopX() {
		return getPosicionEnX();
	}
        abstract int getPosicionEnX();
}
