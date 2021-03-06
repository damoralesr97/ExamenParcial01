/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaArtista;
import vista.VentanaAsistente;
import vista.VentanaBoleto;
import vista.VentanaFestival;
import vista.VentanaInicial;
import vista.VentanaPresentacion;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaInicial implements ActionListener {
    private VentanaInicial ventanaInicial;

    public EventoVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }

    public VentanaInicial getVentanaInicial() {
        return ventanaInicial;
    }

    public void setVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.ventanaInicial.getMenuItemList().get(0)))
        {
            VentanaFestival vF = new VentanaFestival(this.ventanaInicial.getgD());
            vF.setVisible(true);
            this.ventanaInicial.getEscritorio().add(vF);
        }
        
        if(e.getSource().equals(this.ventanaInicial.getMenuItemList().get(1))){
            VentanaArtista vA = new VentanaArtista(this.ventanaInicial.getgD());
            vA.setVisible(true);
            this.ventanaInicial.getEscritorio().add(vA);
        }
        if(e.getSource().equals(this.ventanaInicial.getMenuItemList().get(2))){
            VentanaPresentacion vP = new VentanaPresentacion(this.ventanaInicial.getgD());
            vP.setVisible(true);
            this.ventanaInicial.getEscritorio().add(vP);
        }
        if(e.getSource().equals(this.ventanaInicial.getMenuItemList().get(3))){
            VentanaAsistente vAS = new VentanaAsistente(this.ventanaInicial.getgD());
            vAS.setVisible(true);
            this.ventanaInicial.getEscritorio().add(vAS);
        }
        if(e.getSource().equals(this.ventanaInicial.getMenuItemList().get(4))){
            VentanaBoleto vB = new VentanaBoleto(this.ventanaInicial.getgD());
            vB.setVisible(true);
            this.ventanaInicial.getEscritorio().add(vB);
        }
    }
    
}
