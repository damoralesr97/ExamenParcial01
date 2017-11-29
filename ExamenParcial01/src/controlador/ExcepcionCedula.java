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
public class ExcepcionCedula extends Exception {

    public ExcepcionCedula() {
        super("CEDULA NO VALIDA");
    }
    
    public boolean verificarCedula(String c){
        if(c.length()<10 || c.length()>10){
            return false;
        }
    return true;
    }
    
    
}
