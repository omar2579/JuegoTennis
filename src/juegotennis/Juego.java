/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotennis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Omar
 */
public class Juego extends JFrame implements ActionListener{
    JButton reset;
    public Juego(){
                reset = new JButton();
                reset.setText("reset");
                reset.setBounds(190, 150, 75, 25);
                reset.setVisible(false);
                reset.addActionListener(this);
                add(reset);
                
                addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { 
                System.exit(0); 
                } 
                }); 

                setSize(600, 400);
                setTitle("Tennis");
                setLayout(null);
                setVisible(true);
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reset) {
            /*jugar=true;
            puntos.reset();*/
            reset.setVisible(false);
        }
    }
}
