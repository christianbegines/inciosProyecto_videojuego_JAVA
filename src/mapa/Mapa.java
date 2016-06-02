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
        int oeste=compensacionX >> 5;
        int este=(compensacionX+pantalla.getANCHO() )>> 5;
        int norte=compensacionY >> 5;
        int sur=(compensacionY+pantalla.getALTO()) >> 5;
    }
    
    public Cuadro obtenerCuadro(int x, int y){
       Cuadro cuadro=null;
       switch(cuadros[x+y*ancho]){
           case 0:{
               cuadro=Cuadro.Desierto;
             
           }break;
           default:cuadros=null;
       } 
        return cuadro;
       
    }
}   
