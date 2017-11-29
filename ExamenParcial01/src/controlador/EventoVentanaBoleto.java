/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Boleto;
import vista.VentanaBoleto;

/**
 *
 * @author bryam
 */
public class EventoVentanaBoleto implements ActionListener {

    private VentanaBoleto ventanaBoleto;

    public EventoVentanaBoleto(VentanaBoleto ventanaBoleto) {
        this.ventanaBoleto = ventanaBoleto;
    }

    public VentanaBoleto getVentanaBoleto() {
        return ventanaBoleto;
    }

    public void setVentanaBoleto(VentanaBoleto ventanaBoleto) {
        this.ventanaBoleto = ventanaBoleto;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String asistente="",festival="";
        char fila='A';
        int columna=1;
        
        asistente=this.ventanaBoleto.getComboList().get(0).getSelectedItem().toString();
        festival=this.ventanaBoleto.getComboList().get(1).getSelectedItem().toString();
        
        Boleto b=new Boleto(this.ventanaBoleto.getgD().buscarAsistente(asistente),this.ventanaBoleto.getgD().buscarFestival(festival),this.ventanaBoleto.getgD().fila(fila),this.ventanaBoleto.getgD().columna(columna));
        this.ventanaBoleto.getgD().addBoleto(b);
        
        Object[][] datoBoleto=this.ventanaBoleto.cargaDatosTabla(this.ventanaBoleto.getgD().getBoletoList().size(),3);
        this.ventanaBoleto.setDatos(datoBoleto);
        this.ventanaBoleto.getModeloTabla().setDataVector(this.ventanaBoleto.getDatos(),this.ventanaBoleto.getEncabezado());
    }
    
}
