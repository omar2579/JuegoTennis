/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class Juego extends JPanel implements Observer{
    Ball ball = new Ball(this);
    Player1 player1;
    Player2 player2;
    boolean play = true;
    int jugador = 1;
    Puntos puntos;
    public Juego(Puntos puntos){
        this.puntos = puntos;
        setSize(600, 400);
        setLayout(null);
        setVisible(true);
        setFocusable(true);
        
        player1 = new Player1(this);
        player2 = new Player2(this);

            addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                            player1.keyReleased(e);
                            player2.keyReleased(e);
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_H && ball.movimientoEnX == 0 && play){
                            ball.sacar(jugador);
                        }
                        if(ball.movimientoEnX != 0){
                            player1.keyPressed(e);
                            player2.keyPressed(e);
                        }
                    }
            });
	}

    void setPuntos(int player){
        puntos.setPuntos(player);
        ball.Reset(player);
        player1.reset();
        player2.reset();
        jugador = player;
    }
    public void move() {
        ball.move();
        player1.move();
        player2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        player1.paint(g2d);
        player2.paint(g2d);
        g.fillRect((this.getWidth()/2)-1, 0, 2, this.getHeight());
    }
	
    public void gameOver() {
        ball.Reset(1);
        play = false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (puntos.win)
            gameOver();
        else 
            play = true;
    }
}
