/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Estudiante
 */
import java.util.List;
import modelo.*;
public class GestionDato {
    
    private List<Artista> artistaList;
    private List<Asistente> asistenteList;
    private List<Boleto> boletoList;
    private List<Festival> festivalList;
    private List<Presentacion> presentacionList;

    public GestionDato(List<Artista> artistaList, List<Asistente> asistenteList, List<Boleto> boletoList, List<Festival> festivalList, List<Presentacion> presentacionList) {
        this.artistaList = artistaList;
        this.asistenteList = asistenteList;
        this.boletoList = boletoList;
        this.festivalList = festivalList;
        this.presentacionList = presentacionList;
    }

    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
    }

    public List<Asistente> getAsistenteList() {
        return asistenteList;
    }

    public void setAsistenteList(List<Asistente> asistenteList) {
        this.asistenteList = asistenteList;
    }

    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    public List<Festival> getFestivalList() {
        return festivalList;
    }

    public void setFestivalList(List<Festival> festivalList) {
        this.festivalList = festivalList;
    }

    public List<Presentacion> getPresentacionList() {
        return presentacionList;
    }

    public void setPresentacionList(List<Presentacion> presentacionList) {
        this.presentacionList = presentacionList;
    }
    
    
}
