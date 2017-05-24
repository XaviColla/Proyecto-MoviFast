/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import Datos.Ubicacion;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Christian Collaguazo
 */
public class StreetView extends Mapa{
    private int mover = 20;
    private int acercamiento = 100;
    private int movimientoVer =0;
    public StreetView(Ubicacion ubicacion) {
        super(ubicacion);
    }
    
    @Override
    public Image dibujarMapa() {
        Image imagenstree = null;
        try {
            imagenstree = streetview.getStreetView(getUbicacion().UbicacionLa_Lo(), getDimencion(), mover, acercamiento, movimientoVer);
        } catch (Exception e) {
            System.out.println("Algo mal.... street");
        }
        
        return imagenstree;
    }

    @Override
    public void setMoverDe() {
        mover = mover % 361;
        mover += 20;
        
    }

    @Override
    public void setMoverIz() {
        
        mover -= 20;
        if(mover < 0)
        {
            mover = 360;
            mover-=20;
        }
        
    }

    @Override
    public void alejarMapa() {
        //super.setMoverAba(); //To change body of generated methods, choose Tools | Templates.
        acercamiento = (acercamiento+20 < 120) ? acercamiento + 20 : 120;
        
    }

    @Override
    public void acercarMapa() {
        acercamiento = (acercamiento-20 > 0) ? acercamiento - 20 : 0 ;
        //super.setMoverArr(); //To change body of generated methods, choose Tools | Templates.
        
    }
    @Override
    public void setMoverArr() {
        //super.setMoverArr(); //To change body of generated methods, choose Tools | Templates.
        movimientoVer = (movimientoVer+20 < 120) ? movimientoVer + 20 : 120;
        
    }
    
    @Override
    public void setMoverAba() {
        movimientoVer = (movimientoVer-20 > 0) ? movimientoVer-20 : 0;
        
        //super.setMoverAba(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    

    
    
    
}
