/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Datos.DatosTaxista;
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
public class Simulaciontaxistas extends Mapa{
    private DatosTaxista taxista1 = new DatosTaxista("Juan", "-2.895660,-79.005252");
    private DatosTaxista taxista2 = new DatosTaxista("Pedro", "-2.897803,-79.009071");
    private DatosTaxista taxista3 = new DatosTaxista("Jose", "-2.901607,-79.007173");
    private DatosTaxista taxista4 = new DatosTaxista("Xavier", "-2.892241,-78.996348");
    private DatosTaxista taxista5 = new DatosTaxista("Christian", "-2.882964,-78.992809");
    private DatosTaxista taxista6 = new DatosTaxista("Alex", "-2.894394,-78.979089");   
    private DatosTaxista taxista7 = new DatosTaxista("Daniel", "-2.892321,-78.962416");
    private DatosTaxista taxista8 = new DatosTaxista("Jhon", "-2.922051,-79.044156");
    private DatosTaxista taxista9 = new DatosTaxista("Edgar", "-2.913684,-78.990956");
    private DatosTaxista taxista10 = new DatosTaxista("Ismael", "-2.905086,-79.001090");
    private DatosTaxista taxista11 = new DatosTaxista("Alfredo", "-2.899972,-79.014994");
    private DatosTaxista taxista12 = new DatosTaxista("Sebastian", "-2.890160,-79.029659");
    private DatosTaxista taxista13 = new DatosTaxista("Wili", "-2.867367,-79.037327");
    private DatosTaxista taxista14 = new DatosTaxista("Bryan", "-2.895394,-79.016919");
    private DatosTaxista taxista15 = new DatosTaxista("Claudio", "-2.907496,-79.020317");
    private DatosTaxista taxista16 = new DatosTaxista("Angel", "-2.886068,-78.984991");
    private DatosTaxista taxista17 = new DatosTaxista("Fabian", "-2.870223,-78.983434");
    private DatosTaxista taxista18 = new DatosTaxista("Jonathan", "-2.883108,-79.007092");
    private DatosTaxista taxista19 = new DatosTaxista("Davis", "-2.889659,-79.023468");
    private DatosTaxista taxista20 = new DatosTaxista("Fernando", "-2.895341,-79.036430");
    private String URLRoot="https://maps.googleapis.com/maps/api/staticmap?center=";
    private List<DatosTaxista> lista = new ArrayList<>();
    private String marcadores;
    private static  Simulaciontaxistas nuevaSimulacion;
    private Simulaciontaxistas(Ubicacion ubicacion) {
        super(ubicacion);
        lista.add(taxista1);
        lista.add(taxista2);
        lista.add(taxista3);
        lista.add(taxista4);
        lista.add(taxista5);
        lista.add(taxista6);
        lista.add(taxista7);
        lista.add(taxista8);
        lista.add(taxista9);
        lista.add(taxista10);
        lista.add(taxista11);
        lista.add(taxista12);
        lista.add(taxista13);
        lista.add(taxista14);
        lista.add(taxista15);
        lista.add(taxista16);
        lista.add(taxista17);
        lista.add(taxista18);
        lista.add(taxista19);
        lista.add(taxista20);
        sacarInfomapa();
        setEscalamovimiento(0.005);
    }
    public static Simulaciontaxistas getInstance(Ubicacion ubicacion)
    {
        nuevaSimulacion = new Simulaciontaxistas(ubicacion);
        return nuevaSimulacion;
    }
    public void sacarInfomapa(){
        String mapa = "";
        for (DatosTaxista dato : getLista() ) {
            mapa+= "&markers=color:yellow%7Clabel:" + dato.getNombre().charAt(0) + "%7C" + dato.getPosicion();
        }
        marcadores = mapa; 
        //System.out.println(URLRoot);
    }
    public void agregarTaxista(String nombre , String posicion)
    {
        DatosTaxista taxitanuevo = new DatosTaxista(nombre, posicion);
        getLista().add(taxitanuevo);
    }

    @Override
    public Image dibujarMapa() {
        URLRoot="https://maps.googleapis.com/maps/api/staticmap?center=";
        URLRoot += getUbicacion().UbicacionLa_Lo() + "&zoom=" +getEscala()+"&size=640x640&maptype=roadmap"; 
        URLRoot += marcadores;
        //System.out.println(URLRoot);
        
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
     * @return the lista
     */
    public List<DatosTaxista> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<DatosTaxista> lista) {
        this.lista = lista;
    }
    
}
