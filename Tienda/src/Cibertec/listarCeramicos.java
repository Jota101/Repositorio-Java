package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listarCeramicos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JTextArea txtS;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listarCeramicos dialog = new listarCeramicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listarCeramicos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 422, 207);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(116, 229, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(215, 229, 89, 23);
			contentPanel.add(btnListar);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("Listado de Ceramicos\n\n");
		txtS.append("Modelo         : "+Tienda.primerProd.precio+"\n");
		txtS.append("Precio         : "+Tienda.primerProd.ancho+"\n");
		txtS.append("Ancho (cm)     : "+Tienda.primerProd.ancho+"\n");
		txtS.append("Largo (cm)     : "+Tienda.primerProd.largo+"\n");
		txtS.append("Espesor (mm)   : "+Tienda.primerProd.espesor+"\n");
		txtS.append("Contenido      : "+Tienda.primerProd.contenido+"\n\n");
		
		txtS.append("Modelo	       : "+Tienda.segundoProd.modelo+"\n");
		txtS.append("Precio         : "+Tienda.segundoProd.precio+"\n");
		txtS.append("Ancho (cm)     : "+Tienda.segundoProd.ancho+"\n");
		txtS.append("Largo (cm)     : "+Tienda.segundoProd.largo+"\n");
		txtS.append("Espesor (mm)   : "+Tienda.segundoProd.espesor+"\n");
		txtS.append("Contenido      : "+Tienda.segundoProd.contenido+"\n\n");
		
		txtS.append("Modelo         : "+Tienda.tercerProd.modelo+"\n");
		txtS.append("Precio         : "+Tienda.tercerProd.precio+"\n");
		txtS.append("Ancho (cm)     : "+Tienda.tercerProd.ancho+"\n");
		txtS.append("Largo (cm)     : "+Tienda.tercerProd.largo+"\n");
		txtS.append("Espesor (mm)   : "+Tienda.tercerProd.espesor+"\n");
		txtS.append("Contenido      : "+Tienda.tercerProd.contenido+"\n\n");
		
		txtS.append("Modelo         : "+Tienda.cuartoProd.modelo+"\n");
		txtS.append("Precio         : "+Tienda.cuartoProd.precio+"\n");
		txtS.append("Ancho (cm)     : "+Tienda.cuartoProd.ancho+"\n");
		txtS.append("Largo (cm)     : "+Tienda.cuartoProd.largo+"\n");
		txtS.append("Espesor (mm)   : "+Tienda.cuartoProd.espesor+"\n");
		txtS.append("Contenido      : "+Tienda.cuartoProd.contenido+"\n\n");
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();
	}
}
