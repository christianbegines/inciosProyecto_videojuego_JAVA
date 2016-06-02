/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 *
 * @author chavo
 */
public class Sprite {
    
    private final int LADO;
    private int x;
    private int y;
    public int[]pixeles;
    private  HojaSprite HOJA;
    
    //coleccion de sprites
    public static Sprite desierto= new Sprite(32,0,0,HojaSprite.desierto);
    public static Sprite vacio=new Sprite(32,0);
    //fin coleccion.
    public Sprite(final int lado,final int columna, final int fila, 
            final HojaSprite hoja){
        this.HOJA=hoja;
        this.LADO=lado;
        pixeles= new int[lado*lado];
        this.x=columna*lado;
        this.y=fila*lado;
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++){
                pixeles[x+y*lado]=hoja.PIXELES[(x+this.x)+(y+this.y)*hoja.getAncho()];
                
                
            }
            
        }
   
    }
    private Sprite(final int lado,final int color) {
        this.LADO=lado;
        pixeles= new int[lado*lado];
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i]=color;
        }
        
    }

    public int getLADO() {
        return LADO;
    }
    
}
