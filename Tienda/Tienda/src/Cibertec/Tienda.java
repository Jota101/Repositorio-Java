package Cibertec;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class Tienda extends JFrame {

	private JPanel contentPane;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarcerámico = new JMenuItem("Consultar cer\u00E1mico");
		mnMantenimiento.add(mntmConsultarcerámico);
		
		mntmModificarcerámico = new JMenuItem("Modificar cer\u00E1mico");
		mnMantenimiento.add(mntmModificarcerámico);
		
		mntmListarcerámico = new JMenuItem("Listar cer\u00E1micos");
		mnMantenimiento.add(mntmListarcerámico);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mnVentas.add(mntmVender);
		
		mntmGenerarreportes = new JMenuItem("Generar reportes");
		mnVentas.add(mntmGenerarreportes);
		
		mnConfiguración = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguración);
		
		mntmConfigurardescuentos = new JMenuItem("Configurar descuentos");
		mnConfiguración.add(mntmConfigurardescuentos);
		
		mntmConfigurarobsequios = new JMenuItem("Configurar obsequios");
		mnConfiguración.add(mntmConfigurarobsequios);
		
		mntmConfigurarcantidadóptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mnConfiguración.add(mntmConfigurarcantidadóptima);
		
		mntmConfigurarcuotadiaria = new JMenuItem("Configurar cuota diaria");
		mnConfiguración.add(mntmConfigurarcuotadiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercadeTienda = new JMenuItem("Acerca de Tienda");
		mnAyuda.add(mntmAcercadeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//centrar formulario
		setLocationRelativeTo(this);
	}
	
}
	
	

