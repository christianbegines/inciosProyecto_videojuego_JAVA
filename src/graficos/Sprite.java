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
    
    private final int lado;
    private int x;
    private int y;
    public int[]pixeles;
    private final HojaSprite hoja;
    public Sprite(final int lado,final int columna, final int fila, 
            final HojaSprite hoja){
        this.hoja=hoja;
        this.lado=lado;
        pixeles= new int[lado*lado];
        this.x=columna*lado;
        this.y=fila*lado;
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++){
                pixeles[x+y*lado]=hoja.pixeles[(x+this.x)+(y+this.y)*hoja.getAncho()];
                
                
            }
            
        }
    }
    
}