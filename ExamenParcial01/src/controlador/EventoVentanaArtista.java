/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Artista;
import vista.VentanaArtista;

/**
 *
 * @author bryam
 */
public class EventoVentanaArtista implements ActionListener {

   private VentanaArtista ventanaArtista;

    public EventoVentanaArtista(VentanaArtista ventanaArtista) {
        this.ventanaArtista = ventanaArtista;
    }

    public VentanaArtista getVentanaArtista() {
        return ventanaArtista;
    }

    public void setVentanaArtista(VentanaArtista ventanaArtista) {
        this.ventanaArtista = ventanaArtista;
    }
   
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cedula="",nombre="",apellido="",genero="";
        boolean bandera=true,banderaCedula=true,banderaLetraN=true,banderaLetraA=true,banderaGenero=true,banderaNuC=true,banderaVacio=true;
        
        ExcepcionUsuario ex=new ExcepcionUsuario(this.ventanaArtista.getgD());
        ExcepcionCedula eC=new ExcepcionCedula();
        ExcepcionControlLetraNumero eCLN=new ExcepcionControlLetraNumero();
        ExcepcionVacio eV=new ExcepcionVacio();
        
        try{
            nombre=this.ventanaArtista.getTxtList().get(0).getText();
            apellido=this.ventanaArtista.getTxtList().get(1).getText();
            cedula=this.ventanaArtista.getTxtList().get(2).getText();
            genero=this.ventanaArtista.getTxtList().get(3).getText(); 
            
            bandera=ex.verificarUsuarioArtista(nombre,apellido,cedula);
            banderaCedula=eC.verificarCedula(cedula);
            banderaLetraN=eCLN.verificar(nombre);
            banderaLetraA=eCLN.verificar(apellido);
            banderaGenero=eCLN.verificar(genero);
            banderaNuC=eCLN.verificarN(cedula);
            banderaVacio=eV.verificarVacioArtista(nombre, apellido, cedula, genero);
            
            if(banderaVacio==false){
                throw new ExcepcionVacio(); 
            }else if(bandera==false){
                throw new ExcepcionUsuario();
            }else if(banderaCedula==false){
                throw new ExcepcionCedula();
            }else if(banderaLetraN==false || banderaLetraA==false || banderaGenero==false || banderaNuC==false){
                throw new ExcepcionControlLetraNumero();
            }
            
        }    
        catch(ExcepcionUsuario exU){
            JOptionPane.showMessageDialog(null,exU.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionCedula excepcionC){
            JOptionPane.showMessageDialog(null,excepcionC.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionControlLetraNumero exCon){
            JOptionPane.showMessageDialog(null,exCon.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch(ExcepcionVacio exV){
            JOptionPane.showMessageDialog(null,exV.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        if(bandera==true && banderaCedula==true && banderaLetraN==true && banderaLetraA==true && banderaGenero==true && banderaNuC==true && banderaVacio==true){
            Artista a=new Artista(nombre,apellido,cedula,genero);
            this.ventanaArtista.getgD().addArtista(a);

            Object[][] datoAspirante=this.ventanaArtista.cargaDatosTabla(this.ventanaArtista.getgD().getArtistaList().size(), 4);
            this.ventanaArtista.setDatos(datoAspirante);
            this.ventanaArtista.getModeloTabla().setDataVector(this.ventanaArtista.getDatos(), this.ventanaArtista.getEncabezado()); 
        }
        
    }
    
}
