/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Festival;
import vista.VentanaFestival;

/**
 *
 * @author bryam
 */
public class EventoVentanaFestival implements ActionListener {

    private VentanaFestival ventanaFestival;

    public EventoVentanaFestival(VentanaFestival ventanaFestival) {
        this.ventanaFestival = ventanaFestival;
    }

    public VentanaFestival getVentanaFestival() {
        return ventanaFestival;
    }

    public void setVentanaFestival(VentanaFestival ventanaFestival) {
        this.ventanaFestival = ventanaFestival;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         String capacidad="",nombre="",fecha="",lugar="";
         
         boolean banderaVacio=true,bandera=true,banderaLetraN=true,banderaNC=true;
         
         ExcepcionVacio eV=new ExcepcionVacio();
         ExcepcionUsuario eU=new ExcepcionUsuario(this.ventanaFestival.getgD());
         ExcepcionControlLetraNumero eCLN=new ExcepcionControlLetraNumero();
        
         try{
             
            nombre=this.ventanaFestival.getTxtList().get(0).getText();
            fecha=this.ventanaFestival.getTxtList().get(1).getText();
            capacidad=this.ventanaFestival.getTxtList().get(2).getText();
            lugar=this.ventanaFestival.getTxtList().get(3).getText();
            
            banderaVacio=eV.verificarVacioFestival(nombre, fecha, capacidad, lugar);
            bandera=eU.verificarFestival(nombre, fecha);
            banderaLetraN= eCLN.verificar(nombre);
            banderaNC=eCLN.verificarN(capacidad);
            
            if(banderaVacio==false){
                throw new ExcepcionVacio();
            }else if(bandera==false){
                throw new ExcepcionUsuario("FESTIVAL YA REGISTRADO");
            }else if(banderaLetraN==false || banderaNC==false){
                throw new ExcepcionControlLetraNumero();
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
         
         if(banderaVacio==true && bandera==true && banderaLetraN==true && banderaNC==true){
            Festival f=new Festival(nombre,fecha,capacidad,lugar);
            this.ventanaFestival.getgD().addFestival(f);

            Object[][] datoFestival=this.ventanaFestival.cargaDatosTabla(this.ventanaFestival.getgD().getFestivalList().size(),4);
            this.ventanaFestival.setDatos(datoFestival);
            this.ventanaFestival.getModeloTabla().setDataVector(this.ventanaFestival.getDatos(),this.ventanaFestival.getEncabezado());
         }
         
    }
    
}
