/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Artista;
import vista.VentanaArtista;

/**
 *
 * @author bryam
 */
public class EventoVentanaArtista implements ActionListener {

   private VentanaArtista ventanaArtista;

    public EventoVentanaArtista(VentanaArtista ventanaArtista) {
        this.ventanaArtista = ventanaArtista;
    }

    public VentanaArtista getVentanaArtista() {
        return ventanaArtista;
    }

    public void setVentanaArtista(VentanaArtista ventanaArtista) {
        this.ventanaArtista = ventanaArtista;
    }
   
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cedula="",nombre="",apellido="",genero="";
            
        nombre=this.ventanaArtista.getTxtList().get(0).getText();
        apellido=this.ventanaArtista.getTxtList().get(1).getText();
        cedula=this.ventanaArtista.getTxtList().get(2).getText();
        genero=this.ventanaArtista.getTxtList().get(3).getText();
        
        Artista a=new Artista(nombre,apellido,cedula,genero);
        this.ventanaArtista.getgD().addArtista(a);
            
        Object[][] datoAspirante=this.ventanaArtista.cargaDatosTabla(this.ventanaArtista.getgD().getArtistaList().size(), 4);
        this.ventanaArtista.setDatos(datoAspirante);
        this.ventanaArtista.getModeloTabla().setDataVector(this.ventanaArtista.getDatos(), this.ventanaArtista.getEncabezado());
    }
    
}
