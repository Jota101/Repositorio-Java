package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acercaTienda extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblAutores;
	private JLabel lblJairFernandezBocanegra;
	private JLabel lblMiguelEduardoCarbajal;
	private JLabel lblSilviaCamilaEncarnacin;
	private JLabel lblOdellYaraethAguilar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			acercaTienda dialog = new acercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public acercaTienda() {
		setResizable(false);
		setBounds(100, 100, 415, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tienda 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(140, 11, 131, 44);
		contentPanel.add(lblNewLabel);
		
		label = new JLabel("__________________________________________________");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBackground(Color.BLACK);
		label.setBounds(30, 44, 379, 14);
		contentPanel.add(label);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAutores.setBounds(172, 66, 64, 14);
		contentPanel.add(lblAutores);
		
		lblJairFernandezBocanegra = new JLabel("Jair Fernandez Bocanegra");
		lblJairFernandezBocanegra.setBounds(127, 91, 193, 14);
		contentPanel.add(lblJairFernandezBocanegra);
		
		lblMiguelEduardoCarbajal = new JLabel("Miguel Eduardo Carbajal Vega");
		lblMiguelEduardoCarbajal.setBounds(127, 110, 193, 14);
		contentPanel.add(lblMiguelEduardoCarbajal);
		
		lblSilviaCamilaEncarnacin = new JLabel("Silvia Camila Encarnaci\u00F3n Quezada");
		lblSilviaCamilaEncarnacin.setBounds(127, 129, 193, 14);
		contentPanel.add(lblSilviaCamilaEncarnacin);
		
		lblOdellYaraethAguilar = new JLabel("Odell Yaraeth Aguilar Sandoval");
		lblOdellYaraethAguilar.setBounds(127, 149, 193, 14);
		contentPanel.add(lblOdellYaraethAguilar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(157, 174, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();
	}
}
