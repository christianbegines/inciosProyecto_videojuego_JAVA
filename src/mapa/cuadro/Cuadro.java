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
   
   public Cuadro(Sprite sprite){
       this.sprite=sprite;
   }
   
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
