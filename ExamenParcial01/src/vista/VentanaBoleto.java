/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaBoleto;
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
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;


/**
 *
 * @author paulo
 */
public class VentanaBoleto extends JInternalFrame
{
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
    
    public VentanaBoleto(GestionDato gD) {
        super("Registrar Boleto",true,true,true,true);
        this.gD = gD;
        this.setSize(300,300);
        this.iniciaComponentes();
    }
    
    
    
    public void iniciaComponentes(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Asistente"));
        this.etiList.add(new JLabel("Festival"));
        this.comboList = new ArrayList<JComboBox>();
        this.comboList.add(new JComboBox(this.cargarComboAsistente()));
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
        panelSup.add(this.boton);
        
        this.encabezado = new Object[3];
        this.encabezado[0] = "Asistente";
        this.encabezado[1] = "Festival";
        this.encabezado[2] = "Asiento";
        
        this.datos = this.cargaDatosTabla(this.gD.getBoletoList().size(), 3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
        this.panelInicial.add(panelSup,BorderLayout.NORTH);
        this.panelInicial.add(this.scroll,BorderLayout.CENTER);
        
        this.boton.addActionListener(new EventoVentanaBoleto(this));
        
        this.add(this.panelInicial);
    }
     public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Boleto b:this.gD.getBoletoList())
        {
            retorno[i][0]=b.getAsistente().getNombre()+" "+b.getAsistente().getApellido();
            retorno[i][1]=b.getFestival().getNombre();
            retorno[i][2]=b.getAsientoFila()+" "+b.getAsientoColumna();
            i++;
        }        
        return retorno;
    }
       public String[] cargarComboAsistente(){
        String[] retorno = new String[this.gD.getAsistenteList().size()];
        int i=0;
        for(Asistente bt:this.gD.getAsistenteList()){
            retorno[i]=bt.getNombre()+" "+bt.getApellido();
            i++;
        }
        return retorno;
    }
    public String[] cargarComboFestival(){
        String[] retorno = new String[this.gD.getFestivalList().size()];
        int i=0;
        for(Festival fest:this.gD.getFestivalList()){
            retorno[i]=fest.getNombre();
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
