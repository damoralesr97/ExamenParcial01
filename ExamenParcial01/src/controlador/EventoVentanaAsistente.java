/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Asistente;
import vista.VentanaAsistente;

/**
 *
 * @author bryam
 */
public class EventoVentanaAsistente implements ActionListener {

    private VentanaAsistente ventanaAsistente;

    public EventoVentanaAsistente(VentanaAsistente ventanaAsistente) {
        this.ventanaAsistente = ventanaAsistente;
    }

    public VentanaAsistente getVentanaAsistente() {
        return ventanaAsistente;
    }

    public void setVentanaAsistente(VentanaAsistente ventanaAsistente) {
        this.ventanaAsistente = ventanaAsistente;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre="",apellido="",cedula="",edad="";
        
        boolean banderaVacio=true,bandera=true,banderaLetraN=true,banderaLetraA=true,banderaNuE=true,banderaNuC=true,banderaCedula=true;
        
        ExcepcionVacio eV=new ExcepcionVacio();
        ExcepcionUsuario eU=new ExcepcionUsuario(this.ventanaAsistente.getgD());
        ExcepcionControlLetraNumero eCLN=new ExcepcionControlLetraNumero();
        ExcepcionCedula eCedula=new ExcepcionCedula();
        
        try{
            
            nombre=this.ventanaAsistente.getTxtList().get(0).getText();
            apellido=this.ventanaAsistente.getTxtList().get(1).getText();
            cedula=this.ventanaAsistente.getTxtList().get(2).getText();
            edad=this.ventanaAsistente.getTxtList().get(3).getText();
            
            banderaVacio=eV.verificarVacioAsistente(nombre,apellido,cedula, edad);
            bandera=eU.verificarAsistente(nombre, apellido,cedula);
            banderaLetraN=eCLN.verificar(nombre);
            banderaLetraA=eCLN.verificar(apellido);
            banderaNuE=eCLN.verificarN(edad);
            banderaNuC=eCLN.verificarN(cedula);
            banderaCedula=eCedula.verificarCedula(cedula);
                    
            if(banderaVacio==false){
                throw new ExcepcionVacio();
            }else if(bandera==false){
                throw new ExcepcionUsuario();
            }else if(banderaLetraN==false || banderaLetraA==false || banderaNuE==false || banderaNuC==false){
                throw new ExcepcionControlLetraNumero();
            }else if(banderaCedula==false){
                throw new ExcepcionCedula();
            }
            
        }
        catch(ExcepcionVacio exV){
            JOptionPane.showMessageDialog(null,exV.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionUsuario exU){
            JOptionPane.showMessageDialog(null,exU.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionControlLetraNumero exC){
             JOptionPane.showMessageDialog(null,exC.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionCedula exCe){
             JOptionPane.showMessageDialog(null,exCe.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        if(bandera==true && banderaCedula==true && banderaLetraN==true && banderaLetraA==true && banderaNuE==true && banderaVacio==true){
            Asistente a=new Asistente(nombre,apellido,cedula,Integer.parseInt(edad));
            this.ventanaAsistente.getgD().addAsistente(a);

            Object[][] datoAspirante=this.ventanaAsistente.cargaDatosTabla(this.ventanaAsistente.getgD().getAsistenteList().size(),4);
            this.ventanaAsistente.setDatos(datoAspirante);
            this.ventanaAsistente.getModeloTabla().setDataVector(this.ventanaAsistente.getDatos(),this.ventanaAsistente.getEncabezado());  
        }
       
        
    }
    
}
