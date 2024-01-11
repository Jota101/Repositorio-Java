package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class configurarObsequio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtObs;
	private JLabel lblaUnidades;
	private JTextField txt1a5;
	private JLabel lblNewLabel_1;
	private JTextField txt6a10;
	private JLabel lblNewLabel_2;
	private JTextField txt11amas;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private boolean verificador1,verificador2,verificador3,verificador4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarObsequio dialog = new configurarObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public configurarObsequio() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 358, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de obsequio");
		lblNewLabel.setBounds(10, 10, 86, 14);
		contentPanel.add(lblNewLabel);
		
		txtObs = new JTextField();
		txtObs.setBounds(120, 7, 86, 20);
		contentPanel.add(txtObs);
		txtObs.setColumns(10);
		txtObs.setText(Tienda.tipoObsequio);
		
		lblaUnidades = new JLabel("1 a 5 unidades");
		lblaUnidades.setBounds(10, 40, 86, 14);
		contentPanel.add(lblaUnidades);
		
		txt1a5 = new JTextField();
		txt1a5.setBounds(120, 37, 86, 20);
		contentPanel.add(txt1a5);
		txt1a5.setColumns(10);
		txt1a5.setText(String.valueOf(Tienda.obsequioCantidad1));
		
		lblNewLabel_1 = new JLabel("6 a 10 unidades");
		lblNewLabel_1.setBounds(10, 70, 86, 14);
		contentPanel.add(lblNewLabel_1);
		
		txt6a10 = new JTextField();
		txt6a10.setBounds(120, 67, 86, 20);
		contentPanel.add(txt6a10);
		txt6a10.setColumns(10);
		txt6a10.setText(String.valueOf(Tienda.obsequioCantidad2));
		
		lblNewLabel_2 = new JLabel("11 a mas unidades");
		lblNewLabel_2.setBounds(10, 100, 96, 14);
		contentPanel.add(lblNewLabel_2);
		
		txt11amas = new JTextField();
		txt11amas.setBounds(120, 97, 86, 20);
		contentPanel.add(txt11amas);
		txt11amas.setColumns(10);
		txt11amas.setText(String.valueOf(Tienda.obsequioCantidad3));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(247, 36, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(247, 70, 89, 23);
		contentPanel.add(btnCancelar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		if(txtObs.getText().length()!=0){
			Tienda.tipoObsequio=txtObs.getText();
		}
		else if (txtObs.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Falta especficar el tipo de obsequio!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if(txtObs.getText()==Tienda.tipoObsequio){
			verificador1=false;
		}
		
		if(txt1a5.getText().length()!=0){
			Tienda.obsequioCantidad1=Integer.parseInt(txt1a5.getText());
		}
		else if(txt1a5.getText()==String.valueOf(Tienda.obsequioCantidad1)){
			verificador2=false;
		}
		
		if(txt6a10.getText().length()!=0){
			Tienda.obsequioCantidad2=Integer.parseInt(txt6a10.getText());
		}
		else if(txt6a10.getText()==String.valueOf(Tienda.obsequioCantidad2)){
			verificador3=false;
		}
		
		if(txt11amas.getText().length()!=0){
			Tienda.obsequioCantidad3=Integer.parseInt(txt11amas.getText());
		}
		else if(txt11amas.getText()==String.valueOf(Tienda.obsequioCantidad3)){
			verificador4=false;
		}
		
		if(verificador1==false && verificador2==false && verificador3==false && verificador4 ==false){
			JOptionPane.showMessageDialog(null, "Ningun valor ha sido actualizado");
			this.dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "Valores actualizados");
			this.dispose();
		}
		
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
}
