/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Artista;
import modelo.Festival;
import modelo.Presentacion;

/**
 *
 * @author DavidMorales
 */
public class VentanaPresentacion extends JInternalFrame {
    private List<JLabel> etiList;
    private JTextField txt;
    private JButton boton;
    private List<JComboBox> comboList;
    private JPanel panelInicial;
    private GestionDato gD;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaPresentacion(GestionDato gD) {
        super("Registrar Presentacion",true,true,true,true);
        this.gD = gD;
        this.setSize(500,600);
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Artista"));
        this.etiList.add(new JLabel("Festival"));
        this.etiList.add(new JLabel("Orden"));
        this.comboList = new ArrayList<JComboBox>();
        this.comboList.add(new JComboBox(this.cargarComboArtista()));
        this.comboList.add(new JComboBox(this.cargarComboFestival()));
        this.txt = new JTextField();
        this.boton = new JButton("Guardar");
        
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelInicial = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(3,2);
        JPanel panelSup = new JPanel(disenioSup);
        for(int i=0;i<2;i++){
            panelSup.add(this.etiList.get(i));
            panelSup.add(this.comboList.get(i));
        }
        panelSup.add(this.etiList.get(2));
        panelSup.add(this.txt);
        this.panelInicial.add(panelSup,BorderLayout.NORTH);
        this.panelInicial.add(this.boton,BorderLayout.CENTER);
        
        this.encabezado = new Object[3];
        this.encabezado[0] = "Artista";
        this.encabezado[1] = "Festival";
        this.encabezado[2] = "Orden";
        
        this.datos = this.cargaDatosTabla(this.gD.getFestivalList().size(), 3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
        this.panelInicial.add(this.scroll,BorderLayout.SOUTH);
        
        this.add(this.panelInicial);
    }
    
    public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Presentacion pr:this.gD.getPresentacionList())
        {
            retorno[i][0]=pr.getArtista().getNombre()+" "+pr.getArtista().getApellido();
            retorno[i][1]=pr.getFestival().getNombre();
            retorno[i][2]=pr.getOrden();
            i++;
        }        
        return retorno;
    }
    
    public String[] cargarComboArtista(){
        String[] retorno = new String[this.gD.getArtistaList().size()];
        int i=0;
        for(Artista ar:this.gD.getArtistaList()){
            retorno[i]=ar.getNombre()+" "+ar.getApellido();
            i++;
        }
        return retorno;
    }
    
    public String[] cargarComboFestival(){
        String[] retorno = new String[this.gD.getFestivalList().size()];
        int i=0;
        for(Festival fe:this.gD.getFestivalList()){
            retorno[i]=fe.getNombre();
            i++;
        }
        return retorno;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public JTextField getTxt() {
        return txt;
    }

    public void setTxt(JTextField txt) {
        this.txt = txt;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public List<JComboBox> getComboList() {
        return comboList;
    }

    public void setComboList(List<JComboBox> comboList) {
        this.comboList = comboList;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    
    
}
