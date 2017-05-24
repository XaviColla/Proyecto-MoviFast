/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Datos.Ubicacion;
import java.awt.Dimension;
import java.awt.Image;
import maps.java.StaticMaps;
import maps.java.StreetView;
/**
 *
 * @author Christian Collaguazo
 */
public abstract class Mapa {
    private Ubicacion ubicacion;
    private Dimension dimencion = new Dimension(430 , 410);
    private int pixeles = 1;
    private int escala = 15;
    private String tipo;
    protected StaticMaps mapaestatico;
    protected StreetView streetview;
    //private String latitud;
   // private String longitud;
    private double escalamovimiento = 0.0001;
    
    
    public Mapa(Ubicacion ubicacion) {
        ubicacion.obtenerLayLo(ubicacion);
        this.ubicacion = ubicacion;
        mapaestatico = new StaticMaps();
        streetview = new StreetView();
    }
    
    public abstract Image dibujarMapa();

    /**
     * @return the ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the dimencion
     */
    public Dimension getDimencion() {
        return dimencion;
    }

    /**
     * @param dimencion the dimencion to set
     */
    public void setDimencion(Dimension dimencion) {
        this.dimencion = dimencion;
    }

   
  

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the escala
     */
    public int getEscala() {
        return escala;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(int escala) {
        this.escala = escala;
    }

    /**
     * @return the pixeles
     */
    public int getPixeles() {
        return pixeles;
    }

    

    
    public void setMoverIz() {
        ubicacion.setLongitud(String.valueOf(Double.parseDouble(ubicacion.getLongitud()) - getEscalamovimiento()));
        ubicacion.setLugar(ubicacion.getLatitud() + " , " + ubicacion.getLongitud());
    }

   
    public void setMoverDe() {
        ubicacion.setLongitud(String.valueOf(Double.parseDouble(ubicacion.getLongitud()) + getEscalamovimiento()));
        ubicacion.setLugar(ubicacion.getLatitud() + " , " + ubicacion.getLongitud());
        
    }

    
    public void setMoverArr() {
        ubicacion.setLatitud(String.valueOf(Double.parseDouble(ubicacion.getLatitud()) + getEscalamovimiento()));
        ubicacion.setLugar(ubicacion.getLatitud() + " , " + ubicacion.getLongitud());
    }

    
    public void setMoverAba() {
        ubicacion.setLatitud(String.valueOf(Double.parseDouble(ubicacion.getLatitud()) - getEscalamovimiento()));
        ubicacion.setLugar(ubicacion.getLatitud() + " , " + ubicacion.getLongitud());
    }

    public void acercarMapa(){
        int valor = getEscala() + 1;
        setEscala((valor < 22) ? valor : 21);
    }
    public void alejarMapa(){
        int valor = getEscala() - 1;
        setEscala((valor > 9) ? valor : 10);
    }
            
   /* public void obtenerLayLo(Ubicacion ubicacion)
    {
        System.out.println(ubicacion.getLugar());
        Geocoding geocoding = new Geocoding();
        Point2D.Double lo_la = null;//me guarda la latidud y longitud en un double2d
        try {
            lo_la = geocoding.getCoordinates(ubicacion.getLugar());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLatitud(String.valueOf(lo_la.x));
        setLongitud(String.valueOf(lo_la.y));
    }
    public String UbicacionLa_Lo()
    {
        return latitud + "," + longitud;
    }*/

    /**
     * @return the escalamovimiento
     */
    public double getEscalamovimiento() {
        return escalamovimiento;
    }

    /**
     * @param escalamovimiento the escalamovimiento to set
     */
    public void setEscalamovimiento(double escalamovimiento) {
        this.escalamovimiento = escalamovimiento;
    }
    
            
    
}
