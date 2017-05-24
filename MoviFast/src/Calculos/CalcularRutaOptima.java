/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;
import Datos.PuntosAViajar;
import maps.java.Route;
/**
 *
 * @author Christian Collaguazo
 */
public class CalcularRutaOptima{
    private PuntosAViajar puntos;
    private double matrizdeadyacencia[][];
    private int puntosaviajar[][];
    private double infinito = 99999999;

    public CalcularRutaOptima(PuntosAViajar puntos) {
        this.puntos = puntos;
    }
    public void realizarCalculos()
    {
        puntosaviajar = caminoMasCorto();
        
    }
    public double sacarDistanciaKM(String lugarLlegada , String lugarPartida)
    {
        Route ruta = new Route();
        String[][] caminos;
        Route.mode modoRuta = Route.mode.driving;
        //Vector distancias = new Vector();
        //String distaciaaux = null;
        String valor = null;
        String tipo = null;
        double km = 0;
        try{
            //direccion de salida , direccion de llegada , diferentes puntos , optimizar , modo de viaje(conduccion) , evitar la catera (nada)
            caminos = ruta.getRoute(lugarLlegada, lugarPartida, null, true, modoRuta, Route.avoids.nothing);
            //System.out.println(caminos.length);
            km = (double)ruta.getTotalDistance().get(0);
            km = km/1000;
            /*
            String distancia;
            for (String[] camino : caminos) {
                distancia = null;
                distancia = camino[1];
                int index = distancia.indexOf(" ");
                valor = distancia.substring(0, index);
                tipo = distancia.substring(index + 1, distancia.length());
                if(valor.contains(","))
                {
                    valor = valor.replace(",", ".");
                }
                if(tipo.trim().equals("km")){
                    km += Double.parseDouble(valor);
                }
                else if(tipo.trim().equals("m"))
                {
                    km += Double.parseDouble(valor) / 1000;
                }
                //distancias.add(distancia);
            }*/
        }catch(Exception e){
            System.err.println("ERROR revise su conexion a internet");
            km = sacarDistanciaKM(lugarLlegada, lugarPartida);
        }
        
        /*
        for(int i = 0 ; i < distancias.size() ; i ++)
        {
            distaciaaux =(String)distancias.get(i);
            int index = distaciaaux.indexOf(" ");
            valor = distaciaaux.substring(0, index);
            tipo = distaciaaux.substring(index + 1, distaciaaux.length());
            if(valor.contains(","))
            {
                valor = valor.replace(",", ".");
            }
            if(tipo.trim().equals("km")){
                km += Double.parseDouble(valor);
            }
            else if(tipo.trim().equals("m"))
            {
                km += Double.parseDouble(valor) / 1000;
            }
            
        }*/
        //System.out.println(totalkm);
        //System.out.println(km);
        return km;
    }
    
    public void obtenerMatrizAdyacencia()
    {
        int index = 0;
        setMatrizdeadyacencia(new double[getPuntos().getUbicaciones().size()][getPuntos().getUbicaciones().size()]);
        double km = 0;
        double kmaux = 0;
        for (int i = 0; i < getMatrizdeadyacencia().length; i++) {
            for (int j = index; j < getMatrizdeadyacencia().length; j++) {
                if(i == j)
                {
                    getMatrizdeadyacencia()[i][j] = 0;
                }
                else
                {
                    km= sacarDistanciaKM(getPuntos().getUbicaciones().get(i).UbicacionLa_Lo(),getPuntos().getUbicaciones().get(j).UbicacionLa_Lo() );
                    kmaux = sacarDistanciaKM(getPuntos().getUbicaciones().get(j).UbicacionLa_Lo(), getPuntos().getUbicaciones().get(i).UbicacionLa_Lo());
                    km = (km + kmaux)/2;
                    getMatrizdeadyacencia()[i][j] = km;
                    getMatrizdeadyacencia()[j][i] = km;
                }
            }
            index++;
            
        }
        
    }
    
    public int[][] caminoMasCorto() {
        obtenerMatrizAdyacencia();
        int vecto[] = new int[getMatrizdeadyacencia().length];
        vecto = llenarvecto(vecto);//este vector me llevara la cuenta de a cuantos nodos se conecta el nodo que se esta visitando
        int contadorVertices = 0; 
        int[][] matrizCaminos = new int[getMatrizdeadyacencia().length-1][2];//Aqui se guardara los distintos camininos que se obttengan
        int filaCaminos = 0;
        final int vertices = getMatrizdeadyacencia().length;
        int puntoSalida = 0;//punto salida
        int puntoLlegada = 0;//punto llegada
        double minimo;
        while (contadorVertices < vertices) {
            minimo = getInfinito();
            for (int i = 0; i < vertices; i++) {
                if(puntoSalida == i)
                {
                    matrizdeadyacencia[puntoSalida][i] = infinito;
                }
                else
                {
                    if(matrizdeadyacencia[puntoSalida][i] < minimo && vecto[puntoSalida] < 2 && vecto[i] < 2)//aqui se obtendra el valor de el camino mas corto siempre 
                    {                                                                    //y cuando el nodo visitado  no se conecten a 2 nodos
                        minimo = matrizdeadyacencia[puntoSalida][i];
                        puntoLlegada = i;
                    }
                }
            }
            vecto[puntoSalida]++;
            vecto[puntoLlegada]++;

            contadorVertices++;
            System.out.println("El Vertrice : " + puntoSalida + " , " + puntoLlegada + " Costo de " + minimo);
            matrizCaminos[filaCaminos][0] = puntoSalida;
            matrizCaminos[filaCaminos][1] = puntoLlegada;
            filaCaminos++;
            puntoSalida = puntoLlegada;

            getMatrizdeadyacencia()[puntoSalida][puntoLlegada] = getInfinito() + 100;
            getMatrizdeadyacencia()[puntoLlegada][puntoSalida] = getInfinito() + 100;

            if (filaCaminos == getMatrizdeadyacencia().length - 1) {

                return matrizCaminos;
            }
            
        }

        return matrizCaminos;
    }
    
    
    public double[][] llenarMatriz(double[][] mat)
    {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = getInfinito();
            }
        }
    return mat;}
    public int[] llenarvecto(int[] vec)
    {
        for (int i = 0; i < vec.length; i++) {
            if(i == 0)
            {
                vec[i] = 1;
            }
            else
            {
               vec[i] = 0;
            }
        }
    return vec;
    }

    /**
     * @return the puntos
     */
    public PuntosAViajar getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(PuntosAViajar puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the matrizdeadyacencia
     */
    public double[][] getMatrizdeadyacencia() {
        return matrizdeadyacencia;
    }

    /**
     * @param matrizdeadyacencia the matrizdeadyacencia to set
     */
    public void setMatrizdeadyacencia(double[][] matrizdeadyacencia) {
        this.matrizdeadyacencia = matrizdeadyacencia;
    }

    /**
     * @return the puntosaviajar
     */
    public int[][] getPuntosaviajar() {
        return puntosaviajar;
    }

    /**
     * @param puntosaviajar the puntosaviajar to set
     */
    public void setPuntosaviajar(int[][] puntosaviajar) {
        this.puntosaviajar = puntosaviajar;
    }

    /**
     * @return the infinito
     */
    public double getInfinito() {
        return infinito;
    }

    /**
     * @param infinito the infinito to set
     */
    public void setInfinito(double infinito) {
        this.infinito = infinito;
    }
    
}
