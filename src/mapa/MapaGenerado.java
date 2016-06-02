/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.util.Random;

/**
 *
 * @author chavo
 */
public class MapaGenerado extends Mapa {
    
    private static final Random random= new Random();
    
    public MapaGenerado(int ancho, int alto) {
        super(ancho, alto);
    }
    
    @Override
    protected void generarMapa(){
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
               cuadros[x+y*ancho]= random.nextInt(3);
            }
 
        }
    }
    
}
