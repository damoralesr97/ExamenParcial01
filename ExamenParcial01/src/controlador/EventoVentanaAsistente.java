/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Asistente;
import vista.VentanaAsistente;

/**
 *
 * @author bryam
 */
public class EventoVentanaAsistente implements ActionListener {

    private VentanaAsistente ventanaAsistente;

    public EventoVentanaAsistente(VentanaAsistente ventanaAsistente) {
        this.ventanaAsistente = ventanaAsistente;
    }

    public VentanaAsistente getVentanaAsistente() {
        return ventanaAsistente;
    }

    public void setVentanaAsistente(VentanaAsistente ventanaAsistente) {
        this.ventanaAsistente = ventanaAsistente;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre="",apellido="",cedula="";
        int edad=0;
        
        nombre=this.ventanaAsistente.getTxtList().get(0).getText();
        apellido=this.ventanaAsistente.getTxtList().get(1).getText();
        cedula=this.ventanaAsistente.getTxtList().get(2).getText();
        edad=Integer.parseInt(this.ventanaAsistente.getTxtList().get(3).getText());
        
        System.out.println(nombre+" "+apellido+" "+cedula+" "+edad);
        
        Asistente a=new Asistente(nombre,apellido,cedula,edad);
        this.ventanaAsistente.getgD().addAsistente(a);
        
        Object[][] datoAspirante=this.ventanaAsistente.cargaDatosTabla(this.ventanaAsistente.getgD().getAsistenteList().size(),4);
        this.ventanaAsistente.setDatos(datoAspirante);
        this.ventanaAsistente.getModeloTabla().setDataVector(this.ventanaAsistente.getDatos(),this.ventanaAsistente.getEncabezado());
        
    }
    
}
