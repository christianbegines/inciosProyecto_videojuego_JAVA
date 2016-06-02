/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.util.Random;

/**
 * Representa un MapaGenerado ya que Mapa es abstracta 
 * y no se puede instanciar
 * @author chavo
 */
public class MapaGenerado extends Mapa {
    
    private static final Random random= new Random();
    
    /**
     * MapaGenerado 
     * @param ancho Ancho del mapa
     * @param alto Alto del mapa
     */
    public MapaGenerado(int ancho, int alto) {
        super(ancho, alto);
    }
    
    /**
     * Genera el mapa apartir de un aleatorio, cargando cuadros aleatorios
     */
    @Override
    protected void generarMapa(){
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
               cuadros[x+y*ancho]= random.nextInt(3);
            }
 
        }
    }
    
}
