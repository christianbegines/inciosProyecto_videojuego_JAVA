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
public class Pantalla {
    private final int ANCHO;
    private final int ALTO;
    
    public final int[]pixeles;
    
    public Pantalla(final int ancho,final int alto ){
        this.ALTO=alto;
        this.ANCHO=ancho;
        pixeles=new int[ancho*alto];
        
       
    }
    public void limpiar(){
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i]=0;
        }
    }
    public void mostrar(final int compensacionX,final int compensacionY){
        for (int y = 0; y < ALTO; y++) {
            int posicionY=y+compensacionY;
            if(posicionY<0 || posicionY>=ALTO){
                continue;
            }
            for (int x = 0; x < ANCHO; x++) {
                int posicionX=x+compensacionX;
                if(posicionX<0 || posicionX>=ANCHO){
                continue;
                }
                //codigo para redibujar
            }
        }
    }
}
