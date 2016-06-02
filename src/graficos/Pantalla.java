/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import mapa.cuadro.Cuadro;

/**
 * Ensambla todos los objetos, que
 * deban ser actualizados o separados
 * @author Christian begines
 */
public class Pantalla {

    private final int ANCHO;
    private final int ALTO;

    public final int[] pixeles;
    private int diferenciaX;
    private int diferenciaY;

    //temporal
//    private final static int LADO_SPRITE = 32;
//    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;

    //fin temporal
    public Pantalla(final int ancho, final int alto) {
        this.ALTO = alto;
        this.ANCHO = ancho;
        pixeles = new int[ancho * alto];

    }
    /**
     * Limpia la pantalla para poder repintarla
     */
    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }
 //temporal
//    public void mostrar(final int compensacionX, final int compensacionY) {
//        for (int y = 0; y < ALTO; y++) {
//            int posicionY = y + compensacionY;
//            if (posicionY < 0 || posicionY >= ALTO) {
//                continue;
//            }
//            for (int x = 0; x < ANCHO; x++) {
//                int posicionX = x + compensacionX;
//                if (posicionX < 0 || posicionX >= ANCHO) {
//                    continue;
//                }
//               
//                pixeles[posicionX + posicionY * ANCHO] = Sprite.desierto.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
//
//            }
//        }
//    }
    // fin temporal
    /**
     * Muestra de forma actualizada los Cuadros correspondientes.
     * Asi como los generados por el movimiento del personaje
     * @param compensacionX Nos dice como queda la posicion despues del
     * movimiento  del personaje por el eje X
     * @param compensacionY Nos dice como queda la posicion despues del
     * movimiento del personaje por el eje Y
     * @param cuadro
     */
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {
        compensacionX-=diferenciaX;
        compensacionY-=diferenciaY;
        for (int y = 0; y < cuadro.sprite.getLADO(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.sprite.getLADO(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -cuadro.sprite.getLADO() 
                        || posicionX >= this.ANCHO 
                        || posicionY < 0 
                        || posicionY >= this.ALTO) {
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ANCHO] 
                        = cuadro.sprite.pixeles[x + y * cuadro.sprite.getLADO()];
            }
        }
    }
    public void establecerDiferencia(final int diferenciaX,final int diferenciaY){
        this.diferenciaX=diferenciaX;
        this.diferenciaY=diferenciaY;
    }
    public int getANCHO() {
        return ANCHO;
    }

    public int getALTO() {
        return ALTO;
    }
    
}
