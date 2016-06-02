/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stormrage;

import control.Teclado;
import graficos.Pantalla;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mapa.Mapa;
import mapa.MapaGenerado;

/**
 *Clase principal que implementa los hilos,
 * e extende de Canvas.Es la que se encarga de ejecutar todo mayormente
 * @author Christian Begines
 */
public class Stormrage extends Canvas implements Runnable{
    //atributos de la clase
    public static final long SERIALVERSIONUID=1L; 
   
    //Ancho y alto de la ventana
    private static final int ANCHO=800;
    private static final int ALTO=600;
   
    //Nombre de la ventana
    private static final String NOMBRE="Stormrage";
    
    private static String contador_APS="";
    private static String contador_FPS="";
   
    
    private static int aps=0;
    private static int fps=0;   
    private static volatile boolean enFuncionamiento=false;
    
    private static Thread thread;//primer hilo
    private static Teclado teclado;
    private static JFrame ventanaP;
    private static Pantalla pantalla;//generador de la pantalla
    private static Mapa mapa;
    
    private static int x=0;
    private static int y=0;
    
    
    
    private static BufferedImage imagen= new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
    private static int[]pixeles=((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();
    
    public Stormrage(){
        
        //inicializacion de atributos graficos
        setPreferredSize(new Dimension(ANCHO,ALTO));
        ventanaP= new JFrame(NOMBRE);
        pantalla=new Pantalla(ANCHO,ALTO);
        teclado= new Teclado();
        mapa= new MapaGenerado(128,128);
        
       
        //evento del teclado
        this.addKeyListener(teclado);
        
        //configuracion de la ventana
        ventanaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaP.setResizable(false);
        ventanaP.setLayout(new BorderLayout());
        ventanaP.add(this,BorderLayout.CENTER);
        ventanaP.setUndecorated(true);
        ventanaP.pack();   
        ventanaP.setLocationRelativeTo(null);
        ventanaP.setVisible(true);
        
    }
    /**
     * Realiza lo contenido cuanddo el thread
     * es iniciado.
     */
    @Override
    public  void run() {
        final int NS_POR_SEGUNDO=1000000000;//nanosegundos por segundos
        final byte APS_OBJETIVO=60;//actualizaciones por segundo
        final double NS_POR_ACTUALIZACION=NS_POR_SEGUNDO/APS_OBJETIVO;
        //referencias
        long referenciaActualizacion=System.nanoTime();
        long referenciaContador=System.nanoTime();
        //fin referencias
        double tiempoTranscurrido;
        double delta=0;        
        requestFocus();
        while(enFuncionamiento){  
            final long inicioBucle=System.nanoTime();
            tiempoTranscurrido=inicioBucle-referenciaActualizacion;
            referenciaActualizacion=inicioBucle;
            delta+=tiempoTranscurrido/NS_POR_ACTUALIZACION;
            while(delta>=1){
                actualizar();
                delta--;
            }
            mostrar();
            //esto muestra las APS y los FPS
            if(System.nanoTime()- referenciaContador>NS_POR_SEGUNDO){
              contador_APS="APS:"+aps;
              contador_FPS="FPS:"+fps;
              aps=0;
              fps=0;
              referenciaContador= System.nanoTime();
            }
        }
    }
    /**
     * detiene el thread .
     */
    private synchronized void detener(){
       enFuncionamiento=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stormrage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Inicia el thread con el nombre Graficos
     */
    public synchronized void iniciar(){
        enFuncionamiento=true;
        thread = new Thread(this,"Graficos");
        thread.start();
    }
    /**
     *Da valor y funcionalidad al pulsar las teclas
     * 
     */
    private void actualizar(){
        teclado.actualizar();   
        if(teclado.arriba){
            y--;
        }
        if(teclado.abajo){
            y++;
        }
        if(teclado.izquierda){
            x--;
        }
        if(teclado.derecha){
           x++;
        }    
        if(teclado.salir){
            System.exit(0);
        }
        aps++;
    }
    /**
     * Se encarga de mostrar toda la 
     * parte grafica, cargar los cuadros,rellenar la pantalla
     * Todo lo que tenga que ver con pintar
     * 
     */
    private void mostrar(){
        BufferStrategy estrategia=getBufferStrategy();
        
        if(estrategia==null){
            createBufferStrategy(3);
            return;
        }
        pantalla.limpiar();
        mapa.mostrar(x, y, pantalla);
        
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
//        for (int i = 0; i < pixeles.length; i++) {
//            pixeles[i]=pantalla.pixeles[i];
//        }
        
        Graphics g= estrategia.getDrawGraphics();
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null);
        g.setColor(Color.white);
        g.fillRect(ANCHO/2, ALTO/2, 32, 32);
        g.drawString(contador_APS, 10, 20);
        g.drawString(contador_FPS,10,30);
        g.dispose();
        estrategia.show();
        fps++;
    }
    
    
}
