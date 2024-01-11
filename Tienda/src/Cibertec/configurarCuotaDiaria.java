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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class configurarCuotaDiaria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCD;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private boolean verificador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarCuotaDiaria dialog = new configurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public configurarCuotaDiaria() {
		setTitle("Configurar Cuota Diaria");
		setBounds(100, 100, 423, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuotaDiariaEsperada = new JLabel("Cuota Diaria Esperada (S/.)");
			lblCuotaDiariaEsperada.setBounds(10, 26, 156, 14);
			contentPanel.add(lblCuotaDiariaEsperada);
		}
		{
			txtCD = new JTextField();
			txtCD.setBounds(176, 23, 106, 20);
			contentPanel.add(txtCD);
			txtCD.setColumns(10);
			txtCD.setText(String.valueOf(Tienda.cuotaDiaria));
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(308, 22, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(308, 56, 89, 23);
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
		if(txtCD.getText().length()!=0 && Tienda.cuotaDiaria!=Double.parseDouble(txtCD.getText())){
			Tienda.cuotaDiaria=Double.parseDouble(txtCD.getText());
			JOptionPane.showMessageDialog(null,"Cuota Diaria actualizada");
			this.dispose();
		}
		
		else if(Double.parseDouble(txtCD.getText())==Tienda.cuotaDiaria){
			JOptionPane.showMessageDialog(null, "No se ha modificado el valor");
			this.dispose();
		}
		else if(txtCD.getText().length()==0){
			JOptionPane.showMessageDialog(null, "No ha especificado la Cuota Diaria", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
}
