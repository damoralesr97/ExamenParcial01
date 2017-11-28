/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Presentacion {
    
    private int orden ; 
    private Artista artista;
    private Festival festival; 

    public Presentacion(int orden, Artista artista, Festival festival) {
        this.orden = orden;
        this.artista = artista;
        this.festival = festival;
    }
    
    

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
    
    
}
