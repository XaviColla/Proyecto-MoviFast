/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Datos.Ubicacion;

/**
 *
 * @author Christian Collaguazo
 */
public class InstanceMapaSatelite implements FactoryMapa{

    @Override
    public Mapa getIntacemapa(Ubicacion ubicacion) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return new MapaSatelite(ubicacion);
    }
    
}
