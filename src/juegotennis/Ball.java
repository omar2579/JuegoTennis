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
	int posicionEnX = 10;
	int posicionEnY = 40;
	int movimientoEnX = 0;
	int movimientoEnY = 0;
        int fuerza = 600;
        int velocidad = 2;
	private final Juego juego;

	public Ball(Juego juego) {
		this.juego = juego;
	}
        void move() {
		if (posicionEnX + movimientoEnX < 0)
                    juego.setPuntos(2);
		if (posicionEnX + movimientoEnX > juego.getWidth() - DIAMETER)
                    juego.setPuntos(1);
		if (posicionEnY + movimientoEnY < 0){
                    if(posicionEnX < juego.getWidth()/2){
                        juego.setPuntos(2);
                    }
                    else if(posicionEnX > juego.getWidth()/2){
                        juego.setPuntos(1);
                    }
                }
		if (posicionEnY + movimientoEnY > juego.getHeight() - DIAMETER){
                    if(posicionEnX < juego.getWidth()/2){
                        juego.setPuntos(2);
                    }
                    else if(posicionEnX > juego.getWidth()/2) {
                        juego.setPuntos(1);
                    }
                }
                collision(juego.player1);
                collision(juego.player2);
                if(fuerza>0 && movimientoEnX != 0){
                    fuerza -= velocidad;
                    posicionEnX = posicionEnX + movimientoEnX;
                    posicionEnY = posicionEnY + movimientoEnY;
                }
                if(fuerza <= 0){
                    if(posicionEnX < juego.getWidth()/2)
                        juego.setPuntos(2);
                    else 
                        juego.setPuntos(1);
                }
	}

	private void collision(Player player) {
            if(player.getBounds().intersects(getBounds())){
                if(player.pegar){
                    fuerza = 400;
                    velocidad = 4;
                }
                else{
                    fuerza = 200;
                    velocidad = 2;
                }
                if(player.posicionEnX < juego.getWidth()/2)
                    movimientoEnX = velocidad;
                else
                    movimientoEnX = -velocidad;
                movimientoEnY = (int) (getBounds().getCenterY()-player.getBounds().getCenterY())/5;
            }
	}
	public void paint(Graphics2D g) {
		g.fillOval(posicionEnX, posicionEnY, DIAMETER, DIAMETER);
	}
	public Rectangle getBounds() {
		return new Rectangle(posicionEnX, posicionEnY, DIAMETER, DIAMETER);
	}
    public void Reset(int jugador){
        if(jugador == 1){
            posicionEnX = 10;
            posicionEnY = 40;  
        }
        else{
            posicionEnX = juego.getWidth() - 40;
            posicionEnY = juego.getHeight() - 60;
        }
        fuerza = 600;
        velocidad = 2;
        movimientoEnX = 0;
        movimientoEnY = 0;
    }
    void sacar(int jugador){
        if (jugador == 1)
            movimientoEnX = velocidad;
        else
            movimientoEnX = -velocidad;  
    }
}
