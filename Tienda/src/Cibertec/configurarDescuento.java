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

public class configurarDescuento extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txt1a5;
	private JTextField txt6a10;
	private JTextField txt11a15;
	private JTextField txtmas15;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JButton button;
	private JButton btnCancelar;
	private boolean verificador1=false, verificador2=false,verificador3=false,verificador4=false;
	private JTextField txt1,txt2,txt3,txt4;
	private double valorAntiguo_1=0,valorAntiguo_2=0,valorAntiguo_3=0,valorAntiguo_4=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			configurarDescuento dialog = new configurarDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public configurarDescuento() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 409, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		label = new JLabel("1 a 5 unidades");
		label.setBounds(10, 15, 100, 14);
		contentPanel.add(label);
		
		label_1 = new JLabel("6 a 10 unidades");
		label_1.setBounds(10, 43, 100, 14);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("11 a 15 unidades");
		label_2.setBounds(10, 71, 100, 14);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("Mas de 15 unidades");
		label_3.setBounds(10, 99, 120, 14);
		contentPanel.add(label_3);
		
		txt1a5 = new JTextField();
		txt1a5.setColumns(10);
		txt1a5.setBounds(140, 11, 86, 20);
		contentPanel.add(txt1a5);
		txt1a5.setText(String.valueOf(Tienda.porcentaje1));//Para que nos aparezca el valor primario de porcentaje 1 a 5 al iniciar
		
		txt6a10 = new JTextField();
		txt6a10.setColumns(10);
		txt6a10.setBounds(140, 39, 86, 20);
		contentPanel.add(txt6a10);
		txt6a10.setText(String.valueOf(Tienda.porcentaje2));
		
		txt11a15 = new JTextField();
		txt11a15.setColumns(10);
		txt11a15.setBounds(140, 67, 86, 20);
		contentPanel.add(txt11a15);
		txt11a15.setText(String.valueOf(Tienda.porcentaje3));
		
		txtmas15 = new JTextField();
		txtmas15.setColumns(10);
		txtmas15.setBounds(140, 95, 86, 20);
		contentPanel.add(txtmas15);
		txtmas15.setText(String.valueOf(Tienda.porcentaje4));
		
		label_4 = new JLabel("%");
		label_4.setBounds(228, 14, 19, 14);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("%");
		label_5.setBounds(228, 42, 19, 14);
		contentPanel.add(label_5);
		
		label_6 = new JLabel("%");
		label_6.setBounds(228, 70, 19, 14);
		contentPanel.add(label_6);
		
		label_7 = new JLabel("%");
		label_7.setBounds(228, 98, 19, 14);
		contentPanel.add(label_7);
		
		button = new JButton("Aceptar");
		button.addActionListener(this);
		button.setBounds(294, 11, 89, 23);
		contentPanel.add(button);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(294, 39, 89, 23);
		contentPanel.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) { //Boton de accion Aceptar
		//Obtenemos los valores de los cuadros de texto
		txt1=getValor(txt1a5);//Obtenemos los valores del cuadro de texto
		valorAntiguo_1=getValorAnterior(Tienda.porcentaje1);//Guardamo el valor actual de la variable de la clase "Tienda" para luego analizarla
		txt2=getValor(txt6a10);
		valorAntiguo_2=getValorAnterior(Tienda.porcentaje2);
		txt3=getValor(txt11a15);
		valorAntiguo_3=getValorAnterior(Tienda.porcentaje3);
		txt4=getValor(txtmas15);
		valorAntiguo_4=getValorAnterior(Tienda.porcentaje4);
		JTextField valores[]={txt1,txt2,txt3,txt4};
		//Detectamos  si existen valores vacios
		valorVacio(valores);
		//Detectamos el caso de los cuadros de texto y efectuamos las acciones
		Tienda.porcentaje1=deteccionCaso(txt1,Tienda.porcentaje1);
		verificador1=deteccionVerificador(txt1,valorAntiguo_1);//Metodo con retorno , que nos ayudara a saber si el valor principal es igual o diferente
		Tienda.porcentaje2=deteccionCaso(txt2,Tienda.porcentaje2);
		verificador2=deteccionVerificador(txt2,valorAntiguo_2);
		Tienda.porcentaje3=deteccionCaso(txt3,Tienda.porcentaje3);
		verificador3=deteccionVerificador(txt3,valorAntiguo_3);
		Tienda.porcentaje4=deteccionCaso(txt4,Tienda.porcentaje4);
		verificador4=deteccionVerificador(txt4,valorAntiguo_4);
		//Mandamos mensaje de confirmacion de actualizacion o si no se ha efectuado algun cambio
		condicionVer(verificador1,verificador2,verificador3,verificador4);
	}
	protected void actionPerformedButton_1(ActionEvent arg0) { //Boton de accion Cancelar
		this.dispose();
	}

//Metodos con retorno de valor
	private JTextField getValor(JTextField txt){
		return txt;
	}
	private double getValorAnterior(double valorAnterior){
		return valorAnterior;
	}
	private void valorVacio(JTextField [] valores){
		boolean verificador1=false,verificador2=false,verificador3=false,verificador4=false;
		if(valores[0].getText().length()==0){
			verificador1=true;
		}
		else if(valores[1].getText().length()==0){
			verificador2=true;
		}
		else if(valores[2].getText().length()==0){
			verificador3=true;
		}
		else if(valores[3].getText().length()==0){
			verificador4=true;
		}
		condicionVerificador(verificador1,verificador2,verificador3,verificador4);
	}
	private void condicionVerificador(boolean verificador_1,boolean verificador_2,boolean verificador_3,boolean verificador_4){
		if(verificador_1==true || verificador_2==true || verificador_3==true || verificador_4==true){
			ImprimirDialog("Cuadros de texto sin valores");
		}
	}
	private void ImprimirDialog (String Message){
		JOptionPane.showMessageDialog(null, Message);
	}
	private double deteccionCaso(JTextField txt,double valorTienda){
		double resultado=0;
		if(Double.parseDouble(txt.getText())!=valorTienda){
			resultado= Double.parseDouble(txt.getText());
		}
		else if(Double.parseDouble(txt.getText())==valorTienda){
			resultado= valorTienda;
		}
		return resultado;
	}
	private boolean deteccionVerificador(JTextField txt, double valorAntTienda){
		boolean ver1=false;
		if(Double.parseDouble(txt.getText())!=valorAntTienda){
			ver1=false;
		}
		else if(Double.parseDouble(txt.getText())==valorAntTienda){
			ver1=true;
		}
		return ver1;
	}
	private void condicionVer(boolean ver_1,boolean ver_2,boolean ver_3,boolean ver_4){
		if(ver_1 ==false || ver_2==false || ver_3==false || ver_4==false){
			ImprimirDialog("Valores actualizados con exito!");
			this.dispose();
		}
		else if(ver_1 ==true && ver_2==true && ver_3==true && ver_4==true){
			ImprimirDialog("Los valores no han sido modificados");
			this.dispose();
		}
	}
}
