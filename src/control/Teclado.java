/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *Clase que controla el teclado
 * @author chavo
 */
public class Teclado implements KeyListener {
    
    private final static int NUMEROTECLAS=120;
    private final boolean[] teclas= new boolean[NUMEROTECLAS];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean salir;
     
    
    /**
     * Teclado asigna un valor a las teclas
     */
    public void actualizar(){
        arriba=teclas[KeyEvent.VK_W];
        abajo=teclas[KeyEvent.VK_S];
        izquierda=teclas[KeyEvent.VK_A];
        derecha=teclas[KeyEvent.VK_D];
        salir=teclas[KeyEvent.VK_ESCAPE];
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }
    /**
     * Controla la pulsacion de una tecla
     * @param e evento de teclado
     */
    @Override
    public void keyPressed(KeyEvent e) {
         teclas[e.getKeyCode()]=true;
    }
     /**
     * Controla cuando se deja de pulsar la tecla
     * @param e evento de teclado
     */
    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }
    
}
