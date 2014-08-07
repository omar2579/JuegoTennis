/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegotennis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar
 */
public class Tabla extends JFrame implements Observer{
    
    Puntos puntos;
    JTable tabla;
    DefaultTableModel modelo;
    
    public Tabla(final Puntos puntos){
        this.puntos = puntos;
        modelo = new DefaultTableModel(
                new Object [][] {},
                new String [] {
                    puntos.nombrePlayer1, puntos.nombrePlayer2, "Score"
                }){
                    boolean[] canEdit = new boolean [] {
                        false, false, false
                    };
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                };
        tabla = new JTable(modelo);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(250);
        imprimirTabla();
        tabla.setPreferredScrollableViewportSize(new Dimension(440, 300));
        JScrollPane scrollpane = new JScrollPane(tabla);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                    int row = tabla.getSelectedRow();
                    puntos.changePuntos(Integer.parseInt((String) tabla.getValueAt(row, 0)), Integer.parseInt((String) tabla.getValueAt(row, 1)));
                    puntos.winer();
                    borrarTabla(row+1);
            }
        });
        
        pack(); 
        setSize(440,300);
        setTitle("marcador");
        setLocation(700, 20);
        setLayout(null);
        setVisible(true);
    }
    
    public void imprimirTabla(){
        modelo.addRow(new String[]{Integer.toString(puntos.puntosPlayer1),Integer.toString(puntos.puntosPlayer2),puntos.score()});
    }
    
    public void borrarTabla(int row){
        while (row < modelo.getRowCount()){
            modelo.removeRow(row);
        }
    }
    
    void setIdioma(){
        for (int row = 0; row < modelo.getRowCount(); row++){
            puntos.changePuntos(Integer.parseInt((String) tabla.getValueAt(row, 0)), Integer.parseInt((String) tabla.getValueAt(row, 1)));
            modelo.setValueAt(puntos.score(), row, 2);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        imprimirTabla();
    }
    
}
