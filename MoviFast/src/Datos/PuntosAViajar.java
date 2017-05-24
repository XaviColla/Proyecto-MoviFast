/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Ubicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Collaguazo
 */
public class PuntosAViajar {
    private List<Ubicacion> puntosaviajar = new ArrayList<Ubicacion>();
    private Ubicacion MiUbicacion = null; 
    
   

    /**
     * @return the ubicaciones
     */
    public List<Ubicacion> getUbicaciones() {
        return puntosaviajar;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(List<Ubicacion> puntosaviajar) {
        this.puntosaviajar= puntosaviajar;
    }
     /**
     * @return the MiUbicacion
     */
    public Ubicacion getMiUbicacion() {
        return MiUbicacion;
    }

    /**
     * @param MiUbicacion the MiUbicacion to set
     */
    public void modificarMiUbicacion(Ubicacion MiUbicacion) {
       
       if(MiUbicacion == null)
       {
          this.MiUbicacion = MiUbicacion;  
       }
       else if(getMiUbicacion() != null){
          puntosaviajar.remove(0);
          this.MiUbicacion = MiUbicacion;
          puntosaviajar.add(0, getMiUbicacion());
       }
       else{
           this.MiUbicacion = MiUbicacion;
           puntosaviajar.add(0, getMiUbicacion());
       }
       
       
    }

    public void setMiUbicacion(Ubicacion MiUbicacion) {
        this.MiUbicacion = MiUbicacion;
    }

    
}
