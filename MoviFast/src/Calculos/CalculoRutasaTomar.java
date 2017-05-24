/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import Datos.PuntosAViajar;
import Datos.DatosRuta;
import java.awt.Image;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import maps.java.Route;
import java.net.URL;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;

/**
 *
 * @author Christian Collaguazo
 */
public class CalculoRutasaTomar extends CalculosRuta{
    private final String URLRoot="https://maps.googleapis.com/maps/api/staticmap?size=600x460&path=weight:5%7Ccolor:green%7Cenc:";
    public CalculoRutasaTomar(PuntosAViajar puntos) {
        super(puntos);
    }

    @Override
    public void calculoRuta() {
        ruta = new CalcularRutaOptima(puntos);
        ruta.realizarCalculos();
    }
    
    @Override
    public void dibujarRuta() {
        List<DatosRuta> calles = new ArrayList<>();
        String puntosViajar[];
        String urlweb;
        
        int vectordepuntos[][] = ruta.getPuntosaviajar();
        for (int i = 0; i < vectordepuntos.length; i++) {
            Route rutas = new Route();
            String[][] caminos;
            Route.mode modoRuta = Route.mode.driving;
            puntosViajar = new String[2];
            try{
                //direccion de salida , direccion de llegada , diferentes puntos , optimizar , modo de viaje(conduccion) , evitar la catera (nada)
                caminos = rutas.getRoute(puntos.getUbicaciones().get(vectordepuntos[i][0]).UbicacionLa_Lo(),puntos.getUbicaciones().get(vectordepuntos[i][1]).UbicacionLa_Lo() , null, true, modoRuta, Route.avoids.nothing);
                //System.out.println(puntos.getUbicaciones().get(vectordepuntos[i][0]).UbicacionLa_Lo()+"========="+puntos.getUbicaciones().get(vectordepuntos[i][1]).UbicacionLa_Lo());
                //System.out.println();
//aqui obtengo los urls de los viajes
                //urlweb = "https://www.google.es/maps/dir/" + puntos.getUbicaciones().get(vectordepuntos[i][0]).UbicacionLa_Lo() +"/"+ puntos.getUbicaciones().get(vectordepuntos[i][1]).UbicacionLa_Lo()+"/@-2.8989008,-79.0106905,12z/data=!4m2!4m1!3e0";
                //URI uri = new URI(urlweb);
                //getImagenRutasweb().add(uri);
                //----------------------------------------------------------------------------------------------
                //puntosViajar[0] = puntos.getUbicaciones().get(vectordepuntos[i][0]).getLugar();
               // puntosViajar[1] = puntos.getUbicaciones().get(vectordepuntos[i][1]).getLugar();
                getListaRutasapi().add(rutas);
                //getPuntosviajar().add(puntosViajar);
                //System.out.println(caminos.length);
                //-----------------------------------------------------------------------------------------------
                if(i == vectordepuntos.length-1){
                    getInformaciondelasUbicaciones().add(puntos.getUbicaciones().get(vectordepuntos[i][0]));
                    getInformaciondelasUbicaciones().add(puntos.getUbicaciones().get(vectordepuntos[i][1]));
                }
                else
                {
                    getInformaciondelasUbicaciones().add(puntos.getUbicaciones().get(vectordepuntos[i][0]));
                }
                
                String duracion;
                String distancia;
                String nombreCalle;
                for (int j = 0 ; j < caminos.length ; j++){
                    duracion = caminos[j][0];
                    distancia = caminos[j][1];
                    //Transoforma HTML a texto
                    nombreCalle = Jsoup.parse(caminos[j][2]).text();
                    DatosRuta calle = new DatosRuta(distancia, duracion, nombreCalle);
                    calles.add(calle);
                    
            }
                /*StaticMaps map = new StaticMaps();
                Image Imagenruta = map.getStaticMapRoute(new Dimension(950,950), 1 , StaticMaps.Format.png, StaticMaps.Maptype.roadmap, rutas.getGeneralPolyline() );
                getImagenesruta().add(Imagenruta);*/
                URL url=new URL(URLRoot + rutas.getGeneralPolyline());
                Image imageReturn;
                imageReturn=ImageIO.read(url);
                getListaImagenesruta().add(imageReturn);
               //System.out.println("estre "+ i);
            }catch(Exception e){
                System.err.println("ERROR revise su conexion a internet");
            }
            getListaCalles().add(calles);
            calles = new ArrayList<>();
        }
        
        
    }

    @Override
    public void calcularTiempos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        double tiempomin; 
        
        int tiempo;
        
        List<Route> rutasapi = getListaRutasapi();
        Route route;
        /*List<List<DatosCalle>> listaCalles = getListaCalles();
        String tiempoaux = null;
        String tiempo = null;
        String tipo = null;*/
        for(int i = 0 ; i < rutasapi.size() ; i ++)
        {
            route = rutasapi.get(i);
            tiempomin =(double) route.getTotalTime().get(0);
            tiempomin =Math.floor(tiempomin / 60) ;
            tiempo = (int)tiempomin;
            
            //System.out.println(tiempo);
            /*
            List<DatosCalle> listaCalleaux = getListaCalles().get(i);
            for (int j = 0; j < listaCalleaux.size(); j++) {
                tiempoaux = listaCalleaux.get(j).getTiempo();
                //System.out.println(listaCalleaux.get(j).getTiempo());
                int index = tiempoaux.indexOf(" ");
                tiempo = tiempoaux.substring(0, index);
                tipo = tiempoaux.substring(index + 1, tiempoaux.length());
                if(tipo.trim().equals("min")){
                    tiempomin += Integer.parseInt(tiempo);
                }
            }*/
            getTiempos().add(tiempo);
        }
        
    }

    @Override
    public void calculaKm() {
        double km;
        List<Route> rutasapi = getListaRutasapi();
        Route route;
        for(int i = 0 ; i < rutasapi.size() ; i ++)
        {          
            route = rutasapi.get(i);
            km = (double)route.getTotalDistance().get(0);
            km = km/1000;
            getKm().add(km);
        }
        
    }
/*
    @Override
    public void dibujarRutas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Route> rutasapi = getRutasapi();
        Route route;
        for (int i = 0; i < rutasapi.size(); i++) {
            try{            
            route = rutasapi.get(i);
            StaticMaps map = new StaticMaps();
            Image Imagenruta = map.getStaticMapRoute(new Dimension(950,950), 1 , StaticMaps.Format.png, StaticMaps.Maptype.roadmap, route.getGeneralPolyline() );
            getImagenesruta().add(Imagenruta);
            }catch(Exception e){
            System.out.println("Paso algo al generar la imagen");
            }
        }
        
            
    }*/


    
}
