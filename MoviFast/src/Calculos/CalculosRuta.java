/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import Datos.PuntosAViajar;
import java.util.List;
import Datos.DatosRuta;
import Datos.Ubicacion;
import java.awt.Image;

import java.util.ArrayList;
import maps.java.Route;
import maps.java.StaticMaps;

/**
 *
 * @author Christian Collaguazo
 */
public abstract class CalculosRuta{
     protected CalcularRutaOptima ruta;
     private List<List<DatosRuta>> listaCalles = new ArrayList<>();
     private List<Integer> listaTiempos = new ArrayList<>();
     private List<Double> listaDistacias = new ArrayList<>();
     private List<StaticMaps> listaMapas = new ArrayList<>();
     private List<Route> listaRutasapi = new ArrayList<>();
     private List<Image> listaImagenesruta = new ArrayList<>();
     //private List<String[]> puntosviajar = new ArrayList<>();
     private List<Ubicacion> informaciondelasUbicaciones = new ArrayList<>();
     //private List<URI> imagenRutasweb = new ArrayList<>();
     protected PuntosAViajar puntos;

    public CalculosRuta(PuntosAViajar puntos) {
        this.puntos = puntos;
    }
     
    public  final void realizarCalculos() {
        calculoRuta();
        dibujarRuta();
        calcularTiempos();
        calculaKm();

    }
    public abstract void calculoRuta();
    public abstract void dibujarRuta();
    public abstract void calcularTiempos();
    public abstract void calculaKm();
   // public abstract void dibujarRutas();
    
    /**ca
     * @return the ruta
     */
    public CalcularRutaOptima getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(CalcularRutaOptima ruta) {
        this.ruta = ruta;
    }

   

    /**
     * @return the listaTiempos
     */
    public List<Integer> getTiempos() {
        return listaTiempos;
    }

    /**
     * @param tiempos the listaTiempos to set
     */
    public void setTiempos(List<Integer> tiempos) {
        this.listaTiempos = tiempos;
    }

    /**
     * @return the listaDistacias
     */
    public List<Double> getKm() {
        return listaDistacias;
    }

    /**
     * @param km the listaDistacias to set
     */
    public void setKm(List<Double> km) {
        this.listaDistacias = km;
    }
    
    /**
     * @return the listaCalles
     */
    public List<List<DatosRuta>> getListaCalles() {
        return listaCalles;
    }

    /**
     * @param listaCalles the listaCalles to set
     */
    public void setListaCalles(List<List<DatosRuta>> listaCalles) {
        this.listaCalles = listaCalles;
    }

    /**
     * @return the listaMapas
     */
    public List<StaticMaps> getMapas() {
        return listaMapas;
    }

    /**
     * @param mapas the listaMapas to set
     */
    public void setMapas(List<StaticMaps> mapas) {
        this.listaMapas = mapas;
    }

    /**
     * @return the listaRutasapi
     */
    public List<Route> getListaRutasapi() {
        return listaRutasapi;
    }

    /**
     * @param listaRutasapi the listaRutasapi to set
     */
    public void setListaRutasapi(List<Route> listaRutasapi) {
        this.listaRutasapi = listaRutasapi;
    }

    /**
     * @return the listaImagenesruta
     */
    public List<Image> getListaImagenesruta() {
        return listaImagenesruta;
    }

    /**
     * @param listaImagenesruta the listaImagenesruta to set
     */
    public void setListaImagenesruta(List<Image> listaImagenesruta) {
        this.listaImagenesruta = listaImagenesruta;
    }

    public List<Ubicacion> getInformaciondelasUbicaciones() {
        return informaciondelasUbicaciones;
    }

    /**
     * @param informaciondelasUbicaciones the informaciondelasUbicaciones to set
     */
    public void setInformaciondelasUbicaciones(List<Ubicacion> informaciondelasUbicaciones) {
        this.informaciondelasUbicaciones = informaciondelasUbicaciones;
    }
     
}
