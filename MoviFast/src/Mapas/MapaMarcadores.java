/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Datos.Ubicacion;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian Collaguazo
 */
public class MapaMarcadores extends Mapa{

    private String URLRoot="https://maps.googleapis.com/maps/api/staticmap?center=";
    private String marcadores = "";
    //boolean entro = false;
    public MapaMarcadores(Ubicacion ubicacioncentral) {
        super(ubicacioncentral);
        setEscalamovimiento(0.005);
    }
    
    public void crearMarcadordores(int tienePosIni, String posicion ,int cont)
    {
            if(tienePosIni == 1)
            {
                marcadores += "&markers=color:purple%7Clabel:I%7C"+ posicion;

            }
            else
            {
                marcadores+= "&markers=color:green%7Clabel:P%7C" + posicion;
            }
        
    }
    
    
    @Override
    public Image dibujarMapa() {
        URLRoot="https://maps.googleapis.com/maps/api/staticmap?center=";
        URLRoot += getUbicacion().UbicacionLa_Lo() + "&zoom=" +getEscala()+"&size=640x640&maptype=roadmap";
        URLRoot += marcadores;
        try {
            URL url=new URL(URLRoot);
            Image imageReturn;
            imageReturn=ImageIO.read(url);
            return imageReturn;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return the marcadores
     */
    public String getMarcadores() {
        return marcadores;
    }

    /**
     * @param marcadores the marcadores to set
     */
    public void setMarcadores(String marcadores) {
        this.marcadores = marcadores;
    }

    
}
