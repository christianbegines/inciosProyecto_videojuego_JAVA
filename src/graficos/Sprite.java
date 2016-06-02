/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 * Zona en la que se encuentra un cuadro
 * a partir de la cual se creara su cuadro correspondiente
 * @author Christian begines
 */
public class Sprite {

    private final int LADO;
    private int x;
    private int y;
    public int[] pixeles;
    private HojaSprite HOJA;

    //coleccion de sprites
    public static Sprite desierto = new Sprite(32, 0, 0, HojaSprite.desierto);
    public static Sprite vacio = new Sprite(32, 0x000000);
    //fin coleccion.

    /**
     * Sprite sacado de la hoja, por columna y fila
     *
     * @param lado tamaño del lado del sprite
     * @param columna Columna en la que se encuentra el sprite en la hoja de
     * sprite
     * @param fila Fila donde se encuentra el sprite dentro de la hojaSprite
     * @param hoja Hoja donde se encuentra el sprite.
     */
    public Sprite(final int lado, final int columna, final int fila,
            final HojaSprite hoja) {
        this.HOJA = hoja;
        this.LADO = lado;
        pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila * lado;
        //recorre la hoja de sprite
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.PIXELES[(x + this.x) + (y + this.y) * hoja.getAncho()];

            }

        }

    }

    /**
     * Sprite construido por un color
     *
     * @param lado Tamaño del lado del sprite
     * @param color Color que tendra el sprite
     */
    private Sprite(final int lado, final int color) {
        this.LADO = lado;
        pixeles = new int[lado * lado];
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }

    }

    /**
     * Consulta el lado del sprite.
     *
     * @return Valor del lado.
     */
    public int getLADO() {
        return LADO;
    }

}
