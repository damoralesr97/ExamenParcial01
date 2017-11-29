/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Festival;
import vista.VentanaFestival;

/**
 *
 * @author bryam
 */
public class EventoVentanaFestival implements ActionListener {

    private VentanaFestival ventanaFestival;

    public EventoVentanaFestival(VentanaFestival ventanaFestival) {
        this.ventanaFestival = ventanaFestival;
    }

    public VentanaFestival getVentanaFestival() {
        return ventanaFestival;
    }

    public void setVentanaFestival(VentanaFestival ventanaFestival) {
        this.ventanaFestival = ventanaFestival;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         String capacidad="",nombre="",fecha="",lugar="";
         
         nombre=this.ventanaFestival.getTxtList().get(0).getText();
         fecha=this.ventanaFestival.getTxtList().get(1).getText();
         capacidad=this.ventanaFestival.getTxtList().get(2).getText();
         lugar=this.ventanaFestival.getTxtList().get(3).getText();
         
         Festival f=new Festival(nombre,fecha,capacidad,lugar);
         this.ventanaFestival.getgD().addFestival(f);
         
         Object[][] datoFestival=this.ventanaFestival.cargaDatosTabla(this.ventanaFestival.getgD().getFestivalList().size(),4);
         this.ventanaFestival.setDatos(datoFestival);
         this.ventanaFestival.getModeloTabla().setDataVector(this.ventanaFestival.getDatos(),this.ventanaFestival.getEncabezado());
    }
    
}
