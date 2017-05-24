/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;


import Datos.Ubicacion;
import java.awt.Dimension;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import maps.java.StaticMaps;

/**
 *
 * @author Christian Collaguazo
 */
public class MapaNormal extends Mapa{

    public MapaNormal(Ubicacion ubicacion) {
        
        super(ubicacion);
        
        
    }

    @Override
    public Image dibujarMapa() {
        Image mapanormal = null;
        try {
           mapanormal= mapaestatico.getStaticMap(getUbicacion().UbicacionLa_Lo(),getEscala(), getDimencion(), getPixeles(), StaticMaps.Format.jpg, StaticMaps.Maptype.roadmap);
        } catch (MalformedURLException | UnsupportedEncodingException error){
            System.out.println("Ocurrio un error");
        }
        return mapanormal;
    }
    
}
