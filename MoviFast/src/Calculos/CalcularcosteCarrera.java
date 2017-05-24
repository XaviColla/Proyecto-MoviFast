/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import Mapas.Simulaciontaxistas;
import Datos.DatosCarrera;
import Datos.DatosTaxista;
import Datos.Ubicacion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import maps.java.Route;

/**
 *
 * @author Christian Collaguazo
 */
public class CalcularcosteCarrera {
    private DatosCarrera carrera;
    
    public CalcularcosteCarrera(int tiempo, double distacia,Ubicacion ubicacionSalida, Ubicacion ubicacionLlegada) {
        this.carrera = new DatosCarrera(tiempo, distacia,ubicacionSalida,ubicacionLlegada);
    }
    public final void generarCostos()
    {
        calcularCosteDiurno();
        calcularCosteNocturno();
        obtenerTipoTarifa();
        
        
    }
    private void calcularCosteDiurno()
    {
        double coste = 0;//incializamos el valor de la ruta
        double km = Math.floor(getCarrera().getDistaciaaViajar());//obtenemos la parte entera de la distancia de la carrera
        double sobrante = getCarrera().getDistaciaaViajar() - km;//asi tambien se obtine la parte que sobra en m para calcular su costo
        double costoSobrante;
        if(km < 7)//si el la distancia de la ruta es menor a 7 km
        {
            coste = km * 29 + 55;
            costoSobrante = (sobrante*29);
            coste = coste + costoSobrante;
            coste = redondeo(coste/100);
            
        }
        else//si la distancia es mayor a 7
        {
            double kmaux = km - 7;
            coste = 7 * 29 + 55 + kmaux*36;
            costoSobrante = (sobrante*36);
            coste = coste + costoSobrante;
            coste = redondeo(coste/100);
            
        }
        
        if(coste < 1.39)//si los valores obtenidos son menores a la carrera minima esta toma ser el coste final.
        {
            coste = 1.39;
        }
        getCarrera().setCostoDiurno(coste);
    }
    private void calcularCosteNocturno()
    {
        double coste = 0;
        double km = Math.floor(getCarrera().getDistaciaaViajar());
        double sobrante = getCarrera().getDistaciaaViajar() - km;
        double costoSobrante;
        if(km < 7)
        {
            coste = km * 39 + 55;
            costoSobrante = (sobrante*39);
            coste = coste + costoSobrante;
            coste = redondeo(coste/100);
            
        }
        else
        {
            double kmaux = km - 7;
            coste = 7 * 39 + 55 + kmaux*46;
            costoSobrante = (sobrante*46);
            coste = coste + costoSobrante;
            coste = redondeo(coste/100);
            
        }
        if(coste < 1.67)
        {
            coste = 1.67;
        }
        //System.out.println(coste);
        getCarrera().setCostoNocturno(coste);
    }
    public void llamaraConductor(int cont, CalculosRuta calculosObtenidos, Simulaciontaxistas nuevaSimulacion)
    {
        Route rutas = new Route();
        DatosTaxista taxista = null;
        String ubicacionCliente = calculosObtenidos.getInformaciondelasUbicaciones().get(cont).UbicacionLa_Lo();
        double menordistacia = 999999999;
        double menorTiempo = 0;
        List<Integer> distacia = new ArrayList<>();
        boolean seobtuboDatos = false;
        
        List<DatosTaxista> conductores = nuevaSimulacion.getLista();
        try {
            for(DatosTaxista dato : conductores)
            {
                rutas.getRoute(dato.getPosicion(),ubicacionCliente, null, true, Route.mode.driving, Route.avoids.nothing);
                distacia = rutas.getTotalDistance();
                if(menordistacia > distacia.get(0))
                {
                    menordistacia =(double) distacia.get(0);
                    menorTiempo = (double) rutas.getTotalTime().get(0);
                    System.out.println(menorTiempo);
                    taxista = new DatosTaxista(dato.getNombre(), dato.getPosicion());
                }
            }
            seobtuboDatos = true;
        } catch (Exception e) {
            System.out.println("Error al obtener el taxista : CalcularcosteCarrera 74");
            llamaraConductor(cont, calculosObtenidos, nuevaSimulacion);
            seobtuboDatos = false;
        }
        if(seobtuboDatos == true)
        {
            menorTiempo = Math.floor(menorTiempo/60);
            getCarrera().setTiempodeespera(menorTiempo);
            getCarrera().setConductor(taxista.getNombre());
            getCarrera().setUbicaciolaloConductor(taxista.getPosicion());
        }
        
        
        
        
        
    }
    public  double redondeo(double valorInicial) {
        
        return Math.rint(valorInicial*100)/100;
    }

    /**
     * @return the carrera
     */
    public DatosCarrera getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(DatosCarrera carrera) {
        this.carrera = carrera;
    }
    public void obtenerTipoTarifa()
    {
        Calendar tiempo =Calendar.getInstance();
        int hora;
        hora = tiempo.get(Calendar.HOUR_OF_DAY);
        if(hora == 22 || hora == 23 || (hora>= 0 && hora<=5))
        {
            getCarrera().setTipoTarifa(1);
        }
        else
        {
            getCarrera().setTipoTarifa(0);
        }
    }
}
