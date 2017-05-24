/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
/**
 *
 * @author Christian Collaguazo
 */
public class DatosRuta {
    private String distancia;
    private String tiempo;
    private String nombrecalle;

    public DatosRuta(String distancia, String tiempo, String nombrecalle) {
        this.distancia = distancia;
        this.tiempo = tiempo;
        this.nombrecalle = nombrecalle;
    }

    /**
     * @return the distancia
     */
    public String getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the nombrecalle
     */
    public String getNombrecalle() {
        return nombrecalle;
    }

    /**
     * @param nombrecalle the nombrecalle to set
     */
    public void setNombrecalle(String nombrecalle) {
        this.nombrecalle = nombrecalle;
    }
    
    
}
