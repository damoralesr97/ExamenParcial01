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
public class ExcepcionVacio extends Exception {

    public ExcepcionVacio() {
        super("UNO DE SUS CAMPOS ESTA VACIO");
    }
    
    public boolean verificarVacioArtista(String n,String a,String c,String g){
        if(n.equals("") || a.equals("") || c.equals("") || g.equals("")){
            
            return false;
        }else{
            return true;
        }
    }
    
    public boolean verificarVacioFestival(String n,String f, String c, String l){
        if(n.equals("") || f.equals("") || c.equals("") || l.equals("")){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean verificarVacioPresentacion(String o){
        if(o.equals("")){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean verificarVacioAsistente(String n,String a,String c,String e){
        if(n.equals("") || a.equals("") || c.equals("") || e.equals("")){
            return false;
        }else{
            return true;
        } 
    }
    
}
