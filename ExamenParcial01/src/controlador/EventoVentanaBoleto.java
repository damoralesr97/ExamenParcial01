/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        
        boolean bandera=true;
        
        ExcepcionUsuario eU=new ExcepcionUsuario(this.ventanaBoleto.getgD());
        
        try{
            
            asistente=this.ventanaBoleto.getComboList().get(0).getSelectedItem().toString();
            festival=this.ventanaBoleto.getComboList().get(1).getSelectedItem().toString();
            
            bandera=eU.verificarBoleto(asistente, festival);
            
            if(bandera==false){
                throw new ExcepcionUsuario();
            }
        }
        catch(ExcepcionUsuario exU){
            JOptionPane.showMessageDialog(null,exU.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        if(bandera==true){
            Boleto b=new Boleto(this.ventanaBoleto.getgD().buscarAsistente(asistente),this.ventanaBoleto.getgD().buscarFestival(festival),this.ventanaBoleto.getgD().fila(fila),this.ventanaBoleto.getgD().columna(columna));
            this.ventanaBoleto.getgD().addBoleto(b);

            Object[][] datoBoleto=this.ventanaBoleto.cargaDatosTabla(this.ventanaBoleto.getgD().getBoletoList().size(),3);
            this.ventanaBoleto.setDatos(datoBoleto);
            this.ventanaBoleto.getModeloTabla().setDataVector(this.ventanaBoleto.getDatos(),this.ventanaBoleto.getEncabezado());
        }
        
    }
    
}
