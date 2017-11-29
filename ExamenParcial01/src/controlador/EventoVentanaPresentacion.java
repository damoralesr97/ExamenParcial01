/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Presentacion;
import vista.VentanaPresentacion;

/**
 *
 * @author bryam
 */
public class EventoVentanaPresentacion implements ActionListener {

    private VentanaPresentacion ventanaPresentacion;

    public EventoVentanaPresentacion(VentanaPresentacion ventanaPresentacion) {
        this.ventanaPresentacion = ventanaPresentacion;
    }

    public VentanaPresentacion getVentanaPresentacion() {
        return ventanaPresentacion;
    }

    public void setVentanaPresentacion(VentanaPresentacion ventanaPresentacion) {
        this.ventanaPresentacion = ventanaPresentacion;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String artista="",festival="";
        int orden=0;
        
        artista=this.ventanaPresentacion.getComboList().get(0).getSelectedItem().toString();
        festival=this.ventanaPresentacion.getComboList().get(1).getSelectedItem().toString();
        orden=Integer.parseInt(this.ventanaPresentacion.getTxt().getText());
        
        Presentacion p=new Presentacion(this.ventanaPresentacion.getgD().buscarArtista(artista),this.ventanaPresentacion.getgD().buscarFestival(festival),orden);
        this.ventanaPresentacion.getgD().addPresentacion(p);
        
        Object[][] datoPresentacion=this.ventanaPresentacion.cargaDatosTabla(this.ventanaPresentacion.getgD().getPresentacionList().size(),3);
        this.ventanaPresentacion.setDatos(datoPresentacion);
        this.ventanaPresentacion.getModeloTabla().setDataVector(this.ventanaPresentacion.getDatos(),this.ventanaPresentacion.getEncabezado());
        
    }
    
}
