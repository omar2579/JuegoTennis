/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import javax.swing.JFrame;

/**
 *
 * @author Omar
 */
public class JuegoTennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Juego juego = new Juego();
        JFrame frame = new JFrame("Mini Tennis");
		frame.add(juego);
		frame.setSize(615, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
               if(juego.play()){
                   juego.move();
                   juego.repaint();
                   Thread.sleep(5);
               }
        }
    }
}
