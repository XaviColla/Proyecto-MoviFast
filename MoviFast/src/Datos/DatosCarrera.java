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
public class DatosCarrera {
    private int tiempo;
    private double distaciaaViajar;
    private String conductor;
    private double costoDiurno;
    private double costoNocturno;
    private double tiempodeespera;
    private Ubicacion ubicacionSalida;
    private Ubicacion ubiacionLlegada;
    private String ubicaciolaloConductor;
    private String NombreUsuario;
    private int tipoTarifa = -1; //0 - diurna 1 -nocturna

    public DatosCarrera(int tiempo, double distacia , Ubicacion ubicacionSalida , Ubicacion ubicacionLlegada) {
        this.tiempo = tiempo;
        this.distaciaaViajar = distacia;
        this.ubicacionSalida = ubicacionSalida;
        this.ubiacionLlegada = ubicacionLlegada;
    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the distaciaaViajar
     */
    public double getDistaciaaViajar() {
        return distaciaaViajar;
    }

    /**
     * @param distaciaaViajar the distaciaaViajar to set
     */
    public void setDistaciaaViajar(double distaciaaViajar) {
        this.distaciaaViajar = distaciaaViajar;
    }

    /**
     * @return the conductor
     */
    public String getConductor() {
        return conductor;
    }

    /**
     * @param conductor the conductor to set
     */
    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    /**
     * @return the costoDiurno
     */
    public double getCostoDiurno() {
        return costoDiurno;
    }

    /**
     * @param costoDiurno the costoDiurno to set
     */
    public void setCostoDiurno(double costoDiurno) {
        this.costoDiurno = costoDiurno;
    }

    /**
     * @return the costoNocturno
     */
    public double getCostoNocturno() {
        return costoNocturno;
    }

    /**
     * @param costoNocturno the costoNocturno to set
     */
    public void setCostoNocturno(double costoNocturno) {
        this.costoNocturno = costoNocturno;
    }

    /**
     * @return the tiempodeespera
     */
    public double getTiempodeespera() {
        return tiempodeespera;
    }

    /**
     * @param tiempodeespera the tiempodeespera to set
     */
    public void setTiempodeespera(double tiempodeespera) {
        this.tiempodeespera = tiempodeespera;
    }

    /**
     * @return the ubicacionSalida
     */
    public Ubicacion getUbicacionSalida() {
        return ubicacionSalida;
    }

    /**
     * @param ubicacionSalida the ubicacionSalida to set
     */
    public void setUbicacionSalida(Ubicacion ubicacionSalida) {
        this.ubicacionSalida = ubicacionSalida;
    }

    /**
     * @return the ubiacionLlegada
     */
    public Ubicacion getUbiacionLlegada() {
        return ubiacionLlegada;
    }

    /**
     * @param ubiacionLlegada the ubiacionLlegada to set
     */
    public void setUbiacionLlegada(Ubicacion ubiacionLlegada) {
        this.ubiacionLlegada = ubiacionLlegada;
    }


    /**
     * @return the tipoTarifa
     */
    public int getTipoTarifa() {
        return tipoTarifa;
    }

    /**
     * @param tipoTarifa the tipoTarifa to set
     */
    public void setTipoTarifa(int tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    /**
     * @return the ubicaciolaloConductor
     */
    public String getUbicaciolaloConductor() {
        return ubicaciolaloConductor;
    }

    /**
     * @param ubicaciolaloConductor the ubicaciolaloConductor to set
     */
    public void setUbicaciolaloConductor(String ubicaciolaloConductor) {
        this.ubicaciolaloConductor = ubicaciolaloConductor;
    }

    /**
     * @return the NombreUsuario
     */
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    /**
     * @param NombreUsuario the NombreUsuario to set
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
   
    
    
}
