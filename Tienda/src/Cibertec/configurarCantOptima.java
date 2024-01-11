package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class configurarCantOptima extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private  JTextField txtCO;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarCantOptima dialog = new configurarCantOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public configurarCantOptima() {
		setBounds(100, 100, 450, 113);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtCO = new JTextField();
			txtCO.setBounds(233, 11, 86, 20);
			contentPanel.add(txtCO);
			txtCO.setColumns(10);
			txtCO.setText(String.valueOf(Tienda.cantidadOptima));
		}
		{
			JLabel lblCantidadOptimaDe = new JLabel("Cantidad optima de unidades vendidas");
			lblCantidadOptimaDe.setBounds(10, 14, 213, 14);
			contentPanel.add(lblCantidadOptimaDe);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 10, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 44, 89, 23);
			contentPanel.add(btnCancelar);
		}
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
		if(leerCantOptima().length()!=0 && Tienda.cantidadOptima!=leerCantOptimaINT()){
			actualizarValor();
			this.dispose();
		}
		else if(leerCantOptimaINT()==Tienda.cantidadOptima){
			JOptionPane.showMessageDialog(null, "No ha sido modificado el valor");
			this.dispose();
		}
		else if(leerCantOptima().length()==0){
			JOptionPane.showMessageDialog(null, "No ha agregado un valor", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private  int leerCantOptimaINT (){
		return Integer.parseInt(txtCO.getText());
	}
	String leerCantOptima(){
		return txtCO.getText();
	}
	private  void actualizarValor(){
		Tienda.cantidadOptima=leerCantOptimaINT();
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
}
