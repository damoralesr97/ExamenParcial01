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
public class ExcepcionControlLetraNumero extends Exception {

    public ExcepcionControlLetraNumero() {
         super("INGRESE EL TIPO DE DATO CORRECTO EN EL CAMPO INDICADO");
    }
    
     public boolean verificar(String n){
        boolean bandera=true;
        for(int i=0; i<n.length();i++){
            if(Character.isDigit(n.charAt(i))){
                return bandera=false;
            }
        }
    return bandera;
    }
    
    public boolean verificarN(String nu){
        boolean bandera=true;
        for(int i=0; i<nu.length();i++){
            if(Character.isDigit(nu.charAt(i))){
            }else{
                return bandera=false;
            }
                  
        }
    return bandera;
    }
}
