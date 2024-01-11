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
	private JMenu mnConfiguraci�n;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarcer�mico;
	private JMenuItem mntmModificarcer�mico;
	private JMenuItem mntmListarcer�mico;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarreportes;
	private JMenuItem mntmConfigurardescuentos;
	private JMenuItem mntmConfigurarobsequios;
	private JMenuItem mntmConfigurarcantidad�ptima;
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
		
		mntmConsultarcer�mico = new JMenuItem("Consultar cer\u00E1mico");
		mnMantenimiento.add(mntmConsultarcer�mico);
		
		mntmModificarcer�mico = new JMenuItem("Modificar cer\u00E1mico");
		mnMantenimiento.add(mntmModificarcer�mico);
		
		mntmListarcer�mico = new JMenuItem("Listar cer\u00E1micos");
		mnMantenimiento.add(mntmListarcer�mico);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mnVentas.add(mntmVender);
		
		mntmGenerarreportes = new JMenuItem("Generar reportes");
		mnVentas.add(mntmGenerarreportes);
		
		mnConfiguraci�n = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguraci�n);
		
		mntmConfigurardescuentos = new JMenuItem("Configurar descuentos");
		mnConfiguraci�n.add(mntmConfigurardescuentos);
		
		mntmConfigurarobsequios = new JMenuItem("Configurar obsequios");
		mnConfiguraci�n.add(mntmConfigurarobsequios);
		
		mntmConfigurarcantidad�ptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mnConfiguraci�n.add(mntmConfigurarcantidad�ptima);
		
		mntmConfigurarcuotadiaria = new JMenuItem("Configurar cuota diaria");
		mnConfiguraci�n.add(mntmConfigurarcuotadiaria);
		
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
	
	
