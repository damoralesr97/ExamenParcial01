/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Artista;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;
import modelo.Presentacion;

/**
 *
 * @author bryam
 */
public class ExcepcionUsuario extends Exception {

    private GestionDato gD;
    
    public ExcepcionUsuario(GestionDato gD) {
        this.gD=gD;
    }
    
    public ExcepcionUsuario() {
        super("USUARIO REGISTRADO");
    }
    
    public ExcepcionUsuario(String m){
        super(m);
    }
    
    public boolean verificarUsuarioArtista(String n,String a,String c){
        boolean bandera=true;
        for(Artista ar:this.gD.getArtistaList()){
            if(ar.getNombre().equals(n) && ar.getApellido().equals(a) || ar.getCedula().equals(c)){
                return bandera=false;
            }
        }
    return bandera;
    }
    
    public boolean verificarFestival(String n,String f){
        for(Festival fes:this.gD.getFestivalList()){
            if(fes.getNombre().equals(n) && fes.getFecha().equals(f)){
                return false;
            }
        }
     return true;
    }
    
    public boolean verificarPresentacion(String a, String f){
        String busqueda="";
        for(Presentacion p:this.gD.getPresentacionList()){
            busqueda=p.getArtista().getNombre()+" "+p.getArtista().getApellido();
            if(busqueda.equals(a) && p.getFestival().getNombre().equals(f)){
                return false;
            }
        }
    return true;
    }
    
    public boolean verificarAsistente(String n, String a,String c){
        for(Asistente as:this.gD.getAsistenteList()){
            if(as.getNombre().equals(n) && as.getApellido().equals(a) || as.getCedula().equals(c)){
                return false;
            }
        }
     return true;
    }
    
    public boolean verificarBoleto(String a, String f){
        String buscar="";
        for(Boleto b:this.gD.getBoletoList()){
            buscar=b.getAsistente().getNombre()+" "+b.getAsistente().getApellido();
            if(buscar.equals(a)&&b.getFestival().getNombre().equals(f)){
                return false;
            }
        }
    return true;
    }
    
}
