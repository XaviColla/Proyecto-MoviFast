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
public interface FactoryMapa {
    public Mapa getIntacemapa(Ubicacion ubicacion);
}