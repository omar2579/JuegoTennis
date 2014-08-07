/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegotennis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar
 */
public class Marcador extends JFrame implements ActionListener, Observer{

    JLabel marcador,player1,player2;
    JComboBox idiomas;
    JButton reset;
    String nombrePlayer1,nombrePlayer2;
    Puntos puntos;
    Tabla tabla;
    public Marcador(Puntos puntos){
        this.puntos = puntos;
            nombrePlayer1=JOptionPane.showInputDialog("Nombre Jugador 1").toUpperCase();
            nombrePlayer2=JOptionPane.showInputDialog("Nombre Jugador 2").toUpperCase();
            puntos.setNombreJugador(1, nombrePlayer1);
            puntos.setNombreJugador(2, nombrePlayer2);
            player1 = new JLabel();
            player1.setText(nombrePlayer1);
            player1.setBounds(100, 40, 75, 25);

            player2 = new JLabel();
            player2.setText(nombrePlayer2);
            player2.setBounds(300, 40, 75, 25);

            marcador= new JLabel();
            marcador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            marcador.setBounds(100, 80, 250, 25);
            imprimirMarcador();
            
            idiomas = new JComboBox();
            idiomas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "Español", "français", "Deutsch" }));
            idiomas.setBounds(180, 40, 75, 25);
            idiomas.setVisible(true);
            idiomas.addActionListener(this);
            
            reset = new JButton();
            reset.setText("reset");
            reset.setBounds(270, 100, 75, 25);
            reset.setVisible(false);
            reset.addActionListener(this);
            

            add(player1);
            add(player2);
            add(marcador);
            add(idiomas);
            add(reset);

            setSize(440,230);
            setTitle("Marcador");
            setLocation(400,450);
            setLayout(null);
            setVisible(true);	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reset) {
            reset();
        }
        if (e.getSource()==idiomas){
            switch(idiomas.getSelectedIndex()){
            case 0: puntos.setIdioma(new English());
                break;
            case 1: puntos.setIdioma(new Espanol());
                break;
            case 2: puntos.setIdioma(new Francais());
                break;
            case 3: puntos.setIdioma(new Deutsch());
            }
            tabla.setIdioma();
            imprimirMarcador();
        }
    }
    
    public void imprimirMarcador(){
        marcador.setText(puntos.score());
    }
    void setTabla(Tabla tabla){
        this.tabla = tabla;
    }
    void reset(){
        reset.setVisible(false);
        tabla.borrarTabla(0);
        puntos.reset();
    }
    @Override
    public void update(Observable o, Object arg) {
        imprimirMarcador();
        if (puntos.win)
            reset.setVisible(true);
        else
            reset.setVisible(false);
    }
}
