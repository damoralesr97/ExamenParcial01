/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaInicial;
import controlador.GestionDato;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author DavidMorales
 */
public class VentanaInicial extends JFrame {
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private JMenu menu;
    private List<JMenuItem> menuItemList;
    private GestionDato gD;

    public VentanaInicial(GestionDato gD, String title) throws HeadlessException {
        super(title);
        this.gD = gD;
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(3);
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        this.escritorio = new JDesktopPane();
        this.barraMenu = new JMenuBar();
        this.menu = new JMenu("Registrar");
        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Festival"));
        this.menuItemList.add(new JMenuItem("Artista"));
        this.menuItemList.add(new JMenuItem("Presentacion"));
        this.menuItemList.add(new JMenuItem("Asistente"));
        this.menuItemList.add(new JMenuItem("Boleto"));
        //Agregaras los Action Listener JOVEN VEGA BRYAM
        
        this.menuItemList.get(0).addActionListener(new EventoVentanaInicial(this));
        this.menuItemList.get(1).addActionListener(new EventoVentanaInicial(this));
        this.menuItemList.get(2).addActionListener(new EventoVentanaInicial(this));
        this.menuItemList.get(3).addActionListener(new EventoVentanaInicial(this));
        this.menuItemList.get(4).addActionListener(new EventoVentanaInicial(this));
        
        this.setContentPane(escritorio);
        this.setJMenuBar(barraMenu);
        this.barraMenu.add(this.menu);
        this.menu.add(this.menuItemList.get(0));
        this.menu.add(this.menuItemList.get(1));
        this.menu.add(this.menuItemList.get(2));
        this.menu.add(this.menuItemList.get(3));
        this.menu.add(this.menuItemList.get(4));
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
}
