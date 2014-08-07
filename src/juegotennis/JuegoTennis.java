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
     * @param args the command line argument
     */
    public static void main(String[] args) throws InterruptedException {
        
        Puntos puntos = new Puntos();
        
        Juego juego = new Juego(puntos);
        Marcador marcador = new Marcador(puntos);
        Tabla tabla = new Tabla(puntos);
        marcador.setTabla(tabla);
        puntos.addObserver(juego);
        puntos.addObserver(marcador);
        puntos.addObserver(tabla);
        
        JFrame frame = new JFrame("Mini Tennis");
        frame.add(juego);
        frame.setSize(615, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            juego.move();
            juego.repaint();
            Thread.sleep(10);
        }
    }
}
