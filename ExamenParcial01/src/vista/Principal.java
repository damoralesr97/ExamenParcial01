/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Artista;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;
import modelo.Presentacion;

/**
 *
 * @author DavidMorales
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Artista> artistaList = new ArrayList<Artista>();
        List<Asistente> asistenteList = new ArrayList<Asistente>();
        List<Boleto> boletoList = new ArrayList<Boleto>();
        List<Festival> festivalList = new ArrayList<Festival>();
        List<Presentacion> presentacionList = new ArrayList<Presentacion>();
        
        GestionDato gD = new GestionDato(artistaList,asistenteList,boletoList,festivalList,presentacionList);
        
        VentanaInicial vI = new VentanaInicial(gD,"Examen Parcial 01");
        vI.setVisible(true);
    }
    
}
