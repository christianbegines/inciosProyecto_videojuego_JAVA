/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.cuadro.Cuadro;

/**
 *
 * @author chavo
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
    
    protected int[]cuadros;
    
    
    public Mapa(int ancho,int alto){
        this.alto=alto;
        this.ancho=ancho;
        cuadros=new int[ancho*alto];
        generarMapa();
    }
    public Mapa(String ruta){
        cargarMapa(ruta);
    }
    
    protected void generarMapa(){
        
    }
    private void cargarMapa(String ruta){
        
    }
    public void actualizar(){
        
    }
    public void mostrar(int compensacionX,int compensacionY,Pantalla pantalla){
        pantalla.establecerDiferencia(compensacionX, compensacionY);
        
        int oeste=compensacionX >> 5;
        int este=(compensacionX+pantalla.getANCHO()+Cuadro.lado) >> 5;
        int norte=compensacionY >> 5;
        int sud=(compensacionY+pantalla.getALTO()+Cuadro.lado) >> 5;
        for (int y = 0; y < sud; y++) {
            for (int x = 0; x < este; x++) {
                obtenerCuadro(x,y).mostrar(x, y, pantalla);
            }
            
        }
    }
    /**
     * Busca en el array de cuadros una posicion, y 
     * lo identifica a partir de un numero aleatorio, 
     * que representa un <code>Cuadro<code>
     * @param x 
     * @param y
     * @return 
     */
    public Cuadro obtenerCuadro(int x, int y){
       Cuadro cuadro=Cuadro.vacio;
       
       if(x<0 || y<0 || x>=ancho || y>=alto){
           cuadro=Cuadro.vacio;
       }
       switch(cuadros[x+y*ancho]){
           case 0:
               cuadro=Cuadro.Desierto;   
           break;
           case 1:
               break;
           case 2:
               break;
           case 3:
               break;
           
       } 
        return cuadro;
       
    }
}   
