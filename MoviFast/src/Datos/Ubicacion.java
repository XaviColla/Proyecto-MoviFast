/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Mapas.Mapa;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import maps.java.Geocoding;

/**
 *
 * @author Christian Collaguazo
 */
public final class Ubicacion {
    private String lugar;
    private String latitud;
    private String longitud;
    private boolean esNormal;

    public Ubicacion(String lugar){
        this.lugar = lugar;
        realizarTarea();
        
        
    }
    public void realizarTarea()
    {
        setLugar(lugar);
    }
    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        String comprovacion[];
        comprovacion = lugar.split(",");
        if(!esNumerico(comprovacion[0])){
            this.lugar = lugar + ", Cuenca, Ecuador";
            esNormal = true;
            obtenerLayLo(this);
        }else
        {
            esNormal = false;
            int index = lugar.indexOf(",", 0);
            
            setLatitud(lugar.substring(0, index).trim());
            setLongitud(lugar.substring(index + 1, lugar.length()).trim());
            obtenerNombreLugar();
            
            
        }
    }
    public void setLugar2(String lugar)
    {
        this.lugar = lugar;
    }
    private static boolean esNumerico(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    public void obtenerLayLo(Ubicacion ubicacion)
    {
        if(esNormal){
            //System.out.println(ubicacion.getLugar());
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
        
    }
    public void obtenerNombreLugar() 
    {
        if(!esNormal)
        {
            ArrayList<String> nombresLugar = null;
            try {
                Geocoding geocoding = new Geocoding();
                
                try {
                    nombresLugar = geocoding.getAddress(Double.valueOf(getLatitud()),Double.valueOf(getLongitud()));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                setLugar2(nombresLugar.get(0));
           
                
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Error en la ");
            }
        }
        //System.out.println(getLugar());
    }
    public String UbicacionLa_Lo()
    {
        return getLatitud() + "," + getLongitud(); 
        
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    
}
