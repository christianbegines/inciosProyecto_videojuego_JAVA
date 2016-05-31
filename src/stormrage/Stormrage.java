/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormrage;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author chavo
 */
public class Stormrage extends Canvas implements Runnable{
    
    private static JFrame ventanaP;
    private static final int ANCHO=800;
    private static final int ALTO=600;
    private static final String nombre="Stormrage";
    private static Thread thread;
    
    Stormrage(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        
        
        ventanaP= new JFrame(nombre);
        ventanaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaP.setResizable(false);
        ventanaP.setLayout(new BorderLayout());
        ventanaP.add(this,BorderLayout.CENTER);
        ventanaP.pack();
        ventanaP.setLocationRelativeTo(null);
        ventanaP.setVisible(true);
        
    }

    @Override
    public void run() {
    
    }
    private void detener(){
       
    }
    private void iniciar(){
        thread = new Thread();
    }
}
