package Cibertec;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import Cibertec.configurarDescuento;
import Cibertec.datosProductos;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Tienda extends JFrame implements ActionListener {

	private JPanel panelContenido;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguración;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarcerámico;
	private JMenuItem mntmModificarcerámico;
	private JMenuItem mntmListarcerámico;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarreportes;
	private JMenuItem mntmConfigurardescuentos;
	private JMenuItem mntmConfigurarobsequios;
	private JMenuItem mntmConfigurarcantidadóptima;
	private JMenuItem mntmConfigurarcuotadiaria;
	private JMenuItem mntmAcercadeTienda;
	Panel p;
	
	
	//Declaracion de variables globales
	
	/*Se crea una clase de nombre "datosProductos" para almacenar dichas variables en un constructor
	 * y luego almacenarlas en esta main clase a travez del uso del objeto*/
	
	//Datos minimos del primer producto
	/*public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;*/
	public static datosProductos primerProd = new datosProductos("Cinza Plus",92.56,62.0,62.0,8,6);
	
	// Datos mínimos del segundo producto
	/*public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;*/
	public static datosProductos segundoProd = new datosProductos("Luxury",42.77,60,60,8.5,4);
	
	// Datos mínimos del tercer producto
	/*public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;*/
	public static datosProductos tercerProd = new datosProductos("Austria",52.45,45,45,6.5,12);
	
	// Datos mínimos del cuarto producto
	/*public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;*/
	public static datosProductos cuartoProd = new datosProductos("Yungay Mix",55.89,80,120,6.8,9);
	
	// Datos mínimos del quinto producto
	/*public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;*/
	public static datosProductos quintoProd = new datosProductos("Thalia",45,45,11.8,7.2,10);
	
	
	// Porcentajes de descuento
	public static double porcentaje1 = 0.075;
	public static double porcentaje2 = 0.1;
	public static double porcentaje3 = 0.125;
	public static double porcentaje4 = 0.15;
	
	
	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	
	
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	
	//Variable Ventas.java
	public static int contNroVentas;
	public static double contadorVentas;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Programa de Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jair\\Downloads\\picture-icon-4.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 358);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarcerámico = new JMenuItem("Consultar cer\u00E1mico");
		mntmConsultarcerámico.addActionListener(this);
		mnMantenimiento.add(mntmConsultarcerámico);
		
		mntmModificarcerámico = new JMenuItem("Modificar cer\u00E1mico");
		mntmModificarcerámico.addActionListener(this);
		mnMantenimiento.add(mntmModificarcerámico);
		
		mntmListarcerámico = new JMenuItem("Listar cer\u00E1micos");
		mntmListarcerámico.addActionListener(this);
		mnMantenimiento.add(mntmListarcerámico);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarreportes = new JMenuItem("Generar reportes");
		mntmGenerarreportes.addActionListener(this);
		mnVentas.add(mntmGenerarreportes);
		
		mnConfiguración = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguración);
		
		mntmConfigurardescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurardescuentos.addActionListener(this);
		mnConfiguración.add(mntmConfigurardescuentos);
		
		mntmConfigurarobsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarobsequios.addActionListener(this);
		mnConfiguración.add(mntmConfigurarobsequios);
		
		mntmConfigurarcantidadóptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarcantidadóptima.addActionListener(this);
		mnConfiguración.add(mntmConfigurarcantidadóptima);
		
		mntmConfigurarcuotadiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarcuotadiaria.addActionListener(this);
		mnConfiguración.add(mntmConfigurarcuotadiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercadeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercadeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercadeTienda);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelContenido);
		panelContenido.setLayout(null);
		//centrar formulario
		setLocationRelativeTo(this);
		
		Container contentpane=getContentPane();
		p= new Panel();
		panelContenido.add(p);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmAcercadeTienda) {
			actionPerformedMntmAcercadeTienda(arg0);
		}
		if (arg0.getSource() == mntmGenerarreportes) {
			actionPerformedMntmGenerarreportes(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmModificarcerámico) {
			actionPerformedMntmModificarcerámico(arg0);
		}
		if (arg0.getSource() == mntmListarcerámico) {
			actionPerformedMntmListarcerámico(arg0);
		}
		if (arg0.getSource() == mntmConsultarcerámico) {
			actionPerformedMntmConsultarcerámico(arg0);
		}
		if (arg0.getSource() == mntmConfigurarcuotadiaria) {
			actionPerformedMntmConfigurarcuotadiaria(arg0);
		}
		if (arg0.getSource() == mntmConfigurarcantidadóptima) {
			actionPerformedMntmConfigurarcantidadóptima(arg0);
		}
		if (arg0.getSource() == mntmConfigurarobsequios) {
			actionPerformedMntmConfigurarobsequios(arg0);
		}
		if (arg0.getSource() == mntmConfigurardescuentos) {
			actionPerformedMntmConfigurardescuentos(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		//Accion boton salir
		System.exit(0);
	}
	
	
	
	protected void actionPerformedMntmConfigurardescuentos(ActionEvent arg0) {
		configurarDescuento confDesc = new configurarDescuento();
		confDesc.setLocationRelativeTo(this);
		confDesc.setVisible(true);
		confDesc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	protected void actionPerformedMntmConfigurarobsequios(ActionEvent arg0) {
		configurarObsequio confObs = new configurarObsequio();
		confObs.setLocationRelativeTo(this);
		confObs.setVisible(true);
		confObs.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	protected void actionPerformedMntmConfigurarcantidadóptima(ActionEvent arg0) {
		configurarCantOptima confCO = new configurarCantOptima();
		confCO.setLocationRelativeTo(this);
		confCO.setVisible(true);
		confCO.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	protected void actionPerformedMntmConfigurarcuotadiaria(ActionEvent arg0) {
		configurarCuotaDiaria confCD = new configurarCuotaDiaria();
		confCD.setLocationRelativeTo(this);
		confCD.setVisible(true);
		confCD.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	protected void actionPerformedMntmConsultarcerámico(ActionEvent arg0) {
		consultarCeramico consCera = new consultarCeramico();
		consCera.setLocationRelativeTo(this);
		consCera.setVisible(true);
		
		
	}
	protected void actionPerformedMntmListarcerámico(ActionEvent arg0) {
		listarCeramicos listCera = new listarCeramicos();
		listCera.setLocationRelativeTo(this);
		listCera.setVisible(true);
	}
	protected void actionPerformedMntmModificarcerámico(ActionEvent arg0) {
		modificarCeramico modfCera = new modificarCeramico();
		modfCera.setLocationRelativeTo(this);
		modfCera.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		Ventas vender = new Ventas();
		vender.setLocationRelativeTo(this);
		vender.setVisible(true);
	}
	protected void actionPerformedMntmGenerarreportes(ActionEvent arg0) {
		generarReportes generarRep = new generarReportes();
		generarRep.setLocationRelativeTo(this);
		generarRep.setVisible(true);
	}
	protected void actionPerformedMntmAcercadeTienda(ActionEvent arg0) {
		acercaTienda acercaTda=new acercaTienda();
		acercaTda.setLocationRelativeTo(this);
		acercaTda.setVisible(true);
	}
}
	
	

