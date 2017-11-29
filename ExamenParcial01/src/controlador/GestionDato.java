/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author bryam
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
    
    public boolean addArtista(Artista a){
        return this.artistaList.add(a);
    }
    
    public boolean addAsistente(Asistente as){
        return this.asistenteList.add(as);
    }
    
    public boolean addBoleto(Boleto b){
        return this.boletoList.add(b);
    }
    
    public boolean addFestival(Festival f){
        return this.festivalList.add(f);
    }
    
    public boolean addPresentacion(Presentacion p){
        return this.presentacionList.add(p);
    }
    
    public Artista buscarArtista(String artista){
        String buscar="";
        for(Artista a:this.getArtistaList()){
            buscar=a.getNombre()+" "+a.getApellido();
            if(buscar.equals(artista)){
                return a;
            }
        }
    return null;
    }
    
    public Festival buscarFestival(String festival){
        String buscar="";
        for(Festival f:this.getFestivalList()){
            buscar=f.getNombre();
            if(buscar.equals(festival)){
                return f;
            }
        }
    return null;
    }
    
    public Asistente buscarAsistente(String asistente){
        String buscar="";
        for(Asistente a:this.getAsistenteList()){
            buscar=a.getNombre()+" "+a.getApellido();
            if(buscar.equals(asistente)){
                return a;
            }
        }
    return null;
    }
    
    public char fila(char a){
        int contador=0;
        if(this.getBoletoList().size()!=0){
            a=this.getBoletoList().get(this.getBoletoList().size()-1).getAsientoFila();
        }   
        for(Boleto b:this.getBoletoList()){
            if(b.getAsientoFila()==a){
                contador++;
            }
            if(contador==5){
                return (char)(a+1);
            }
        }
    return a;
    }
    
     public int columna(int c){
        int contador=0;
         if(this.getBoletoList().size()!=0){
            c=this.getBoletoList().get(this.getBoletoList().size()-1).getAsientoColumna();
            contador=this.getBoletoList().get(this.getBoletoList().size()-1).getAsientoColumna();
        }   
        for(Boleto b:this.getBoletoList()){
            if(c==5){
                return 1;
            }else if(b.getAsientoColumna()==contador){
                contador++;
                return contador;
            }
        }
    return c;
    }
    
}
