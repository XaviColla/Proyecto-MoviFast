/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Mapas.MapasenNavegador;
import Datos.DatosCarrera;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import javax.swing.DefaultListModel;

/**
 *
 * @author Christian Collaguazo
 */
public class AppInfoCarreraTaxista extends javax.swing.JFrame {

    /**
     * Creates new form AppInfoCarrera
     */
    private DatosCarrera carrera;
    private int cambiarFondo = -1;
    DefaultListModel model = new DefaultListModel();
    public AppInfoCarreraTaxista(DatosCarrera carrera) {
        initComponents();
        if(new File("Movifast_Arch\\fondo.obj").exists()){
            try {
                ObjectInputStream arch = new ObjectInputStream(new FileInputStream("Movifast_Arch\\fondo.obj"));
                Object[] args;
                args = (Object[]) arch.readObject();
                arch.close();
                this.cambiarFondo = (int) args[0];
                if(cambiarFondo == 1)
                {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_Info_Carrera_2.jpg"))); // NOI18N
                }
                else if (cambiarFondo == 0)
                {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_Info_Carrera_1.jpg"))); // NOI18N
                }
                
                
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Algo paso");
                cambiarFondo = -1;}
        }
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //-------------------------------------------------------------------------------------------------------
        this.carrera = carrera;
        model.clear();
        model.addElement("Nombre del Cliente: " + carrera.getNombreUsuario());
        model.addElement("Tiempo de llegada aproximado: " + carrera.getTiempodeespera() + " min");
        if(carrera.getTipoTarifa() == 0)
        {
            model.addElement("Tipo de Tarifa: Diurna");
            model.addElement("Valor aproximado del costo de la carrera: " + carrera.getCostoDiurno());
        }
        else
        {
            model.addElement("Tipo de Tarifa: Nocturna");
            model.addElement("Valor aproximado del costo de la carrera: " + carrera.getCostoNocturno());
            
        }
        model.addElement("Ubicacion de Salida: " + carrera.getUbicacionSalida().getLugar());
        model.addElement("Ubicacion de Salida: " + carrera.getUbiacionLlegada().getLugar());
        model.addElement("Tiempo aproximado del viaje: " + carrera.getTiempo() + " min");
        model.addElement("Distancia hasta su destino: " + carrera.getDistaciaaViajar());
        listaInfo.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaInfo = new javax.swing.JList<>();
        botonRegresar = new javax.swing.JButton();
        destinoUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UbicacionUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 460));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaInfo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        listaInfo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaInfo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 470, 200));

        botonRegresar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 140, 50));

        destinoUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        destinoUsuario.setText("Destino del usuario ");
        destinoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(destinoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 170, 50));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informacion de la Carrera");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 390, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoMoviFast2.png"))); // NOI18N
        jLabel2.setText("iconoMovi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 300, 100));

        UbicacionUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UbicacionUsuario.setText("Ubicacion Usuario");
        UbicacionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbicacionUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(UbicacionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 160, 50));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        dispose(); 
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void destinoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoUsuarioActionPerformed
        // TODO add your handling code here:
         MapasenNavegador nuevomapa = MapasenNavegador.getInstance();
         nuevomapa.mostrarImagenNavegador(carrera.getUbicacionSalida().UbicacionLa_Lo(), carrera.getUbiacionLlegada().UbicacionLa_Lo());
         
        
         
    }//GEN-LAST:event_destinoUsuarioActionPerformed

    private void UbicacionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionUsuarioActionPerformed
        // TODO add your handling code here:
         MapasenNavegador nuevomapa = MapasenNavegador.getInstance();
         nuevomapa.mostrarImagenNavegador(carrera.getUbicaciolaloConductor(), carrera.getUbicacionSalida().UbicacionLa_Lo());
    }//GEN-LAST:event_UbicacionUsuarioActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UbicacionUsuario;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton destinoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaInfo;
    // End of variables declaration//GEN-END:variables
}