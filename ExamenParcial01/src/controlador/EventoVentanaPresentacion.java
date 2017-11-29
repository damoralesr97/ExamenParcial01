/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Presentacion;
import vista.VentanaPresentacion;

/**
 *
 * @author bryam
 */
public class EventoVentanaPresentacion implements ActionListener {

    private VentanaPresentacion ventanaPresentacion;

    public EventoVentanaPresentacion(VentanaPresentacion ventanaPresentacion) {
        this.ventanaPresentacion = ventanaPresentacion;
    }

    public VentanaPresentacion getVentanaPresentacion() {
        return ventanaPresentacion;
    }

    public void setVentanaPresentacion(VentanaPresentacion ventanaPresentacion) {
        this.ventanaPresentacion = ventanaPresentacion;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String artista="",festival="",orden="";
        
        boolean banderaVacio=true,bandera=true,banderaNO=true;
        
        ExcepcionVacio eV=new ExcepcionVacio();
        ExcepcionUsuario eU=new ExcepcionUsuario(this.ventanaPresentacion.getgD());
        ExcepcionControlLetraNumero eCLN= new ExcepcionControlLetraNumero();
        
        try{
            
            artista=this.ventanaPresentacion.getComboList().get(0).getSelectedItem().toString();
            festival=this.ventanaPresentacion.getComboList().get(1).getSelectedItem().toString();
            orden=this.ventanaPresentacion.getTxt().getText();   
            
            banderaVacio=eV.verificarVacioPresentacion(orden);
            bandera=eU.verificarPresentacion(artista, festival);
            banderaNO=eCLN.verificarN(orden);
            
            if(banderaVacio==false){
                throw new ExcepcionVacio();
            }else if(bandera==false){
                throw new ExcepcionUsuario("PRESENTACION YA REGISTRADA");
            }else if(banderaNO==false){
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
        
        if(banderaVacio==true && bandera==true && banderaNO==true){
            Presentacion p=new Presentacion(this.ventanaPresentacion.getgD().buscarArtista(artista),this.ventanaPresentacion.getgD().buscarFestival(festival),Integer.parseInt(orden));
            this.ventanaPresentacion.getgD().addPresentacion(p);

            Object[][] datoPresentacion=this.ventanaPresentacion.cargaDatosTabla(this.ventanaPresentacion.getgD().getPresentacionList().size(),3);
            this.ventanaPresentacion.setDatos(datoPresentacion);
            this.ventanaPresentacion.getModeloTabla().setDataVector(this.ventanaPresentacion.getDatos(),this.ventanaPresentacion.getEncabezado());
        }
        
        
    }
    
}
