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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class Juego extends JPanel implements ActionListener{
    Ball ball = new Ball(this);
    Player1 player1 = new Player1(this,0);
    Player2 player2 = new Player2(this,574);
    JButton reset;
    boolean play = true;
    public Juego(){
                reset = new JButton();
                reset.setText("reset");
                reset.setBounds(270, 100, 75, 25);
                reset.setVisible(false);
                reset.addActionListener(this);
                add(reset);
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
				player1.keyPressed(e);
                                player2.keyPressed(e);
			}
		});

                setSize(600, 400);
                setLayout(null);
                setVisible(true);
		setFocusable(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reset) {
            play = true;
            reset.setVisible(false);
        }
    }
    void setPuntos(int player){
        if (player == 1){
            System.out.println("punto player 1");
        }
        else
            System.out.println("punto player 2");
        gameOver();
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
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
            ball.paint(g2d);
            player1.paint(g2d);
            player2.paint(g2d);
    }
	
	public void gameOver() {
                reset.setVisible(true);
                ball.Reset();
                play = false;
	}
       boolean play(){
           return play;
       } 
}
