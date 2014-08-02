/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Omar
 */
public class Ball {
    private static final int DIAMETER = 30;
	int posicionEnX = 200;
	int PosicionEnY = 0;
	int movimientoEnX = 1;
	int MovimientoEnY = 1;
	private final Juego juego;

	public Ball(Juego juego) {
		this.juego= juego;
	}
        void move() {
		if (posicionEnX + movimientoEnX < 0)
                    juego.setPuntos(2);
		if (posicionEnX + movimientoEnX > juego.getWidth() - DIAMETER)
                    juego.setPuntos(1);
		if (PosicionEnY + MovimientoEnY < 0)
			MovimientoEnY = 1;
		if (PosicionEnY + MovimientoEnY > juego.getHeight() - DIAMETER)
                        MovimientoEnY = -1;
                
		movimientoEnX = collision();
		posicionEnX = posicionEnX + movimientoEnX;
		PosicionEnY = PosicionEnY + MovimientoEnY;
	}

	private int collision() {
            if(juego.player1.getBounds().intersects(getBounds()))
		return 1;
            if(juego.player2.getBounds().intersects(getBounds()))
                return -1;
            return movimientoEnX;
	}
	public void paint(Graphics2D g) {
		g.fillOval(posicionEnX, PosicionEnY, DIAMETER, DIAMETER);
	}
	public Rectangle getBounds() {
		return new Rectangle(posicionEnX, PosicionEnY, DIAMETER, DIAMETER);
	}
        public void Reset(){
            posicionEnX = 200;
            PosicionEnY = 0;
            movimientoEnX = 1;
            MovimientoEnY = 1;
        }
}
