/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 *Representa cada cuadrado de 32*32 en el mapa
 * @author chavo
 */
public abstract class Cuadro {
   
    
    //coleccion de cuadros
    public static final Cuadro Desierto=new CuadroDesierto(Sprite.desierto);
    public static final Cuadro vacio=new CuadroVacio(Sprite.vacio);
   //coleccion de cuadros;
    
    
    
   public static final int lado=32; 
   public int x;
   public Sprite sprite;
   
   /**
    * Cuadro a partir de un sprite
    * @param sprite Sprite donde se encuentra el cuadro
    */
   public Cuadro(Sprite sprite){
       this.sprite=sprite;
   }
    
   /**
    * Se mostrara el cuadro en la pantalla
    * @param x Situacion del cuadro en el eje x
    * @param y Situacion del cuadro en el eje y
    * @param pantalla  Pantalla donde se situara el cuadro
    */
   public void mostrar(int x,int y,Pantalla pantalla){
       pantalla.mostrarCuadro(x << 5, y << 5,this);
   }
   /**
    * Comprueba si el cuadro es un 
    * solido o no lo es
    * @return false si no es un solido
    */
   public boolean solido(){
       return false;
   }
}
