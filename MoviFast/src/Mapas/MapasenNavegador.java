/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author Christian Collaguazo
 */
public class MapasenNavegador {
    private static MapasenNavegador nuevaInstance = new MapasenNavegador();
    private MapasenNavegador() {
        
    }
    public static MapasenNavegador getInstance()
    {
        return nuevaInstance;
    }
    public void mostrarImagenNavegador(String ubciacion1 , String Ubicacion2)
    {
        String urlweb = "https://www.google.es/maps/dir/";
        urlweb += ubciacion1 +"/"+Ubicacion2 +"/@-2.9073668,-79.0323931,13.13z/data=!4m2!4m1!3e0"; 
        try {
            URI urlmaps = new URI(urlweb);
            Desktop.getDesktop().browse(urlmaps); 
        } catch (Exception e) {
            System.out.println("ocurrio un problema al abrir el navegador");
        }
    }
    
}
