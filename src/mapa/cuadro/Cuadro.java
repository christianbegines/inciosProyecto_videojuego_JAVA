/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 *
 * @author chavo
 */
public abstract class Cuadro {
   
    
    //coleccion de cuadros
    
    public static final Cuadro Desierto=new CuadroDesierto(Sprite.desierto);
    public static final Cuadro VACIO=new CuadroVacio(Sprite.vacio);
//coleccion de cuadros;
    
    
    
    
   public int x;
   public Sprite sprite;
   
   public Cuadro(Sprite sprite){
       this.sprite=sprite;
   }
   
   public void mostrar(int x,int y,Pantalla pantalla){
       
   }
   
   public boolean solido(){
       return false;
   }
}
