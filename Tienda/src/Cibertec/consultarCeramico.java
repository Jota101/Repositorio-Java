package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class consultarCeramico extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JComboBox cboModelo;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			consultarCeramico dialog = new consultarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * Create the dialog.
	 */
	public consultarCeramico() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Precio (S/)");
			lblNewLabel_1.setBounds(10, 36, 80, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Ancho (cm)");
			lblNewLabel_2.setBounds(10, 61, 80, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Largo (cm)");
			lblNewLabel_3.setBounds(10, 86, 80, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Espesor (mm)");
			lblNewLabel_4.setBounds(10, 111, 80, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Contenido");
			lblNewLabel_5.setBounds(10, 136, 80, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(111, 33, 168, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
			
		}
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
		cboModelo.setBounds(111, 8, 168, 20);
		contentPanel.add(cboModelo);
		
		
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(111, 58, 168, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		
		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setBounds(111, 83, 168, 20);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);
		
		
		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setBounds(111, 108, 168, 20);
		contentPanel.add(txtEspesor);
		txtEspesor.setColumns(10);
		
		
		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setBounds(111, 133, 168, 20);
		contentPanel.add(txtContenido);
		txtContenido.setColumns(10);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(318, 7, 89, 23);
		contentPanel.add(btnCerrar);
		
		cboModelo.setSelectedIndex(0);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		switch(cboModelo.getSelectedIndex()){
			case 0: imprimir(Tienda.primerProd.precio,Tienda.primerProd.ancho,Tienda.primerProd.largo,Tienda.primerProd.espesor,Tienda.primerProd.contenido);
					break;
			case 1: imprimir(Tienda.segundoProd.precio,Tienda.segundoProd.ancho,Tienda.segundoProd.largo,Tienda.segundoProd.espesor,Tienda.segundoProd.contenido);
					break;
			case 2: imprimir(Tienda.tercerProd.precio,Tienda.tercerProd.ancho,Tienda.tercerProd.largo,Tienda.tercerProd.espesor,Tienda.tercerProd.contenido);
					break;
			case 3: imprimir(Tienda.cuartoProd.precio,Tienda.cuartoProd.ancho,Tienda.cuartoProd.largo,Tienda.cuartoProd.espesor,Tienda.cuartoProd.contenido);
					break;
			case 4: imprimir(Tienda.quintoProd.precio,Tienda.quintoProd.ancho,Tienda.quintoProd.largo,Tienda.quintoProd.espesor,Tienda.quintoProd.contenido);
					break;
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	}
	private void imprimir(double precio,double ancho,double largo,double espesor,int contenido){
		txtPrecio.setText(String.valueOf(precio));
		txtAncho.setText(String.valueOf(ancho));
		txtLargo.setText(String.valueOf(largo));
		txtEspesor.setText(String.valueOf(espesor));
		txtContenido.setText(String.valueOf(contenido));
	}
}
