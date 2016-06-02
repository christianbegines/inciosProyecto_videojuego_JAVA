/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import mapa.cuadro.Cuadro;

/**
 *
 * @author chavo
 */
public class Pantalla {

    private final int ANCHO;
    private final int ALTO;

    public final int[] pixeles;

    //temporal
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;

    //fin temporal
    public Pantalla(final int ancho, final int alto) {
        this.ALTO = alto;
        this.ANCHO = ancho;
        pixeles = new int[ancho * alto];

    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }

    public void mostrar(final int compensacionX, final int compensacionY) {
        for (int y = 0; y < ALTO; y++) {
            int posicionY = y + compensacionY;
            if (posicionY < 0 || posicionY >= ALTO) {
                continue;
            }
            for (int x = 0; x < ANCHO; x++) {
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX >= ANCHO) {
                    continue;
                }
                //temporal
                pixeles[posicionX + posicionY * ANCHO] = Sprite.desierto.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];

            }
        }
    }
    // fin temporal

    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {
        for (int y = 0; y < cuadro.sprite.getLADO(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.sprite.getLADO(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX > this.ANCHO 
                        || posicionY < 0 || posicionY > this.ALTO) {
                    break;
                }
                pixeles[posicionX + posicionY * this.ANCHO] 
                        = cuadro.sprite.pixeles[x + y * cuadro.sprite.getLADO()];
            }
        }
    }

    public int getANCHO() {
        return ANCHO;
    }

    public int getALTO() {
        return ALTO;
    }
    
}
