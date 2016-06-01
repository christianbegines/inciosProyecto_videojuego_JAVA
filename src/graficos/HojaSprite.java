/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author chavo
 */
public class HojaSprite {
    public final int[] pixeles;
    private final int alto;
    private final int ancho;
    
    public HojaSprite(final String ruta,final int ancho,final int alto){
        this.alto=alto;
        this.ancho=ancho;
        pixeles=new int[ancho*alto];
        try {
            BufferedImage imagen= ImageIO.read(HojaSprite.class.getResource(ruta));
            imagen.getRGB(0, 0,ancho,alto,pixeles,0,ancho);
        } catch (IOException ex) {
            Logger.getLogger(HojaSprite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public int getAncho() {
        return ancho;
    }
    
    
}
