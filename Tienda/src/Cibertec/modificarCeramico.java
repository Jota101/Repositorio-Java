package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class modificarCeramico extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private static JComboBox cboModelo;
	private JLabel lblPrecios;
	private static JTextField txtPrecio;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private static JTextField txtAncho;
	private JLabel lblEspesormm;
	private JLabel lblContenido;
	private static JTextField txtLargo;
	private static JTextField txtEspesor;
	private static JTextField txtContenido;
	private JButton btnCerrar;
	private JButton btnGrabar;
	
	//Declaramos variables globales a usar
	private static JTextField txt1,txt2,txt3,txt4,txt5,txt6;
	private static double txtAnt1,txtAnt2,txtAnt3,txtAnt4,txtAnt5,txtAnt6;
	private static boolean verif1=false,verif2=false,verif3=false,verif4=false,verif5=false,verif6=false;
	private static double txt_1=0,txt_2=0,txt_3=0,txt_4=0;
	private static int txt_5=0;
	private static double valor1,valor2,valor3,valor4;
	private static int valor5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			modificarCeramico dialog = new modificarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public modificarCeramico() {
		setTitle("Modificar Ceramicos");
		setBounds(100, 100, 425, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 24, 87, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setBounds(104, 21, 165, 20);
		contentPanel.add(cboModelo);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(10, 54, 87, 14);
		contentPanel.add(lblPrecios);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(104, 53, 165, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 84, 87, 14);
		contentPanel.add(lblAncho);
		
		lblLargo = new JLabel(" Largo (cm)");
		lblLargo.setBounds(10, 114, 87, 14);
		contentPanel.add(lblLargo);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(104, 81, 165, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setBounds(10, 144, 87, 14);
		contentPanel.add(lblEspesormm);
		
		lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 174, 87, 14);
		contentPanel.add(lblContenido);
		
		txtLargo = new JTextField();
		txtLargo.setBounds(104, 111, 165, 20);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);
		
		txtEspesor = new JTextField();
		txtEspesor.setBounds(104, 141, 165, 20);
		contentPanel.add(txtEspesor);
		txtEspesor.setColumns(10);
		
		txtContenido = new JTextField();
		txtContenido.setBounds(104, 171, 165, 20);
		contentPanel.add(txtContenido);
		txtContenido.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(307, 50, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(307, 92, 89, 23);
		contentPanel.add(btnGrabar);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
		
		cboModelo.setSelectedIndex(0);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedCboModelo(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		DeteccionAccionesYReaccion();
		this.dispose();
	}
	
	//Seleccion de modelo
	private static void DeteccionAccionesYReaccion(){
		switch(cboModelo.getSelectedIndex()){
			case 0: txt1=getText(txtPrecio);
					txt2=getText(txtAncho);
					txt3=getText(txtLargo);
					txt4=getText(txtEspesor);
					txt5=getText(txtContenido);
					verificadorVacios();
					revisionDeEstado(Tienda.primerProd.precio,Tienda.primerProd.ancho,Tienda.primerProd.largo,Tienda.primerProd.espesor,Tienda.primerProd.contenido);
					break;
					
			case 1: txt1=getText(txtPrecio);
					txt2=getText(txtAncho);
					txt3=getText(txtLargo);
					txt4=getText(txtEspesor);
					txt5=getText(txtContenido);
					verificadorVacios();
					revisionDeEstado(Tienda.segundoProd.precio,Tienda.segundoProd.ancho,Tienda.segundoProd.largo,Tienda.segundoProd.espesor,Tienda.segundoProd.contenido);
					break;
					
			case 2: txt1=getText(txtPrecio);
					txt2=getText(txtAncho);
					txt3=getText(txtLargo);
					txt4=getText(txtEspesor);
					txt5=getText(txtContenido);
					verificadorVacios();
					revisionDeEstado(Tienda.tercerProd.precio,Tienda.tercerProd.ancho,Tienda.tercerProd.largo,Tienda.tercerProd.espesor,Tienda.tercerProd.contenido);
					break;
					
			case 3: txt1=getText(txtPrecio);
					txt2=getText(txtAncho);
					txt3=getText(txtLargo);
					txt4=getText(txtEspesor);
					txt5=getText(txtContenido);
					verificadorVacios();
					revisionDeEstado(Tienda.cuartoProd.precio,Tienda.cuartoProd.ancho,Tienda.cuartoProd.largo,Tienda.cuartoProd.espesor,Tienda.cuartoProd.contenido);
					break;
					
			case 4: txt1=getText(txtPrecio);
					txt2=getText(txtAncho);
					txt3=getText(txtLargo);
					txt4=getText(txtEspesor);
					txt5=getText(txtContenido);
					verificadorVacios();
					revisionDeEstado(Tienda.quintoProd.precio,Tienda.quintoProd.ancho,Tienda.quintoProd.largo,Tienda.quintoProd.espesor,Tienda.quintoProd.contenido);
					break;
		}
	}
	
	
	//Metodo que nos ayuda a obtener el valor de los cuadro de texto
	private static JTextField getText(JTextField txtValor){
		return txtValor;
	}
	
	//Metodo que sirve para saber si hay espacios vacios en los cuadros de texto
	private static void verificadorVacios(){
		if(txt1.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Valor vacio caja 1", "Valores Vacios!!!", JOptionPane.ERROR_MESSAGE);
		}
		else if(txt2.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Valor vacio caja 2", "Valores Vacios!!!", JOptionPane.ERROR_MESSAGE);
		}
		else if(txt3.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Valor vacio caja 3", "Valores Vacios!!!", JOptionPane.ERROR_MESSAGE);
		}
		else if(txt4.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Valor vacio caja 4", "Valores Vacios!!!", JOptionPane.ERROR_MESSAGE);
		}
		else if(txt5.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Valor vacio caja 5", "Valores Vacios!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	//Metodo que nos ayudara a conocer que variable se esta trabajando y comprobar su similitud con el dato actual y tomar acciones
	private static void revisionDeEstado(double precio,double ancho, double largo, double espesor, int contenido){
		//Declaramos variables
		JTextField txt_1 = null;
		double valorTienda=0;
		int valorTienda2=0;
		boolean verificador,ver1=false,ver2=false,ver3=false,ver4=false,ver5=false;
		
		//Bucle para identificar el tipo de dato precio, ancho, largo, espesor y contenido
		for(int i=1;i<=5;i++){
			if(i==1){
				txt_1=txt1;
				valorTienda=precio;
				
			}
			else if(i==2){
				txt_1=txt2;
				valorTienda=ancho;
				
			}
			else if(i==3){
				txt_1=txt3;
				valorTienda=largo;
				
			}
			else if(i==4){
				txt_1=txt4;
				valorTienda=espesor;
				
			}
			else if(i==5){
				txt_1=txt5;
				valorTienda2=contenido;
				
			}
			
			//Dado que existen valores double como int, este metodo nos ayudara a evaluar cada uno por su propio tipo de dato
			verificador=seleccionVerificador(i,valorTienda,valorTienda2,txt_1);
			
			//Actualizemos los valores
			if(verificador==false){
				if(cboModelo.getSelectedIndex()==0){
					actualizarValoresM1(i);
				}
				else if(cboModelo.getSelectedIndex()==1){
					actualizarValoresM2(i);
				}
				else if(cboModelo.getSelectedIndex()==2){
					actualizarValoresM3(i);
				}
				else if(cboModelo.getSelectedIndex()==3){
					actualizarValoresM4(i);
				}
				else if(cboModelo.getSelectedIndex()==4){
					actualizarValoresM5(i);
				}
			}
			
			//Si no hay valores por actualizar que los verificadores se guarden como true y lanzen un mensaje
			else if(verificador==true){
				if(i==1){
					ver1=true;
				}
				else if(i==2){
					ver2=true;
				}
				else if(i==3){
					ver3=true;
				}
				else if(i==4){
					ver4=true;
				}
				else if(i==5){
					ver5=true;
				}
				
			}
		}
		verificadoresParaMSJ(ver1,ver2,ver3,ver4,ver5);//Encargado de revisar los verificadores y lanzar el mensaje
	}
	
	private static boolean seleccionVerificador(int i,double valorTienda,int valorTienda2, JTextField txt){
		boolean _verificador=false;
		if(i==1 || i==2 || i==3 || i==4){
			_verificador=CondicionalDeEstadoD(valorTienda,txt);
		}
		else if(i==5){
			_verificador=CondicionalDeEstadoI(valorTienda2,txt);
		}
		
		return _verificador;
	}
	
	private static boolean CondicionalDeEstadoD(double valorTienda,JTextField txt){//Metodo para los valores Double
		boolean verificador=false;
		if(valorTienda!=Double.parseDouble(txt.getText())){
			verificador=false;
		}
		else if(valorTienda==Double.parseDouble(txt.getText())){
			verificador=true;
		}
		return verificador;
	}
	
	private static boolean CondicionalDeEstadoI(int valorTienda2,JTextField txt){//Metodo para los valores enteros
		boolean verificador=false;
		if(valorTienda2!=Double.parseDouble(txt.getText())){
			verificador=false;
		}
		else if(valorTienda2==Double.parseDouble(txt.getText())){
			verificador=true;
		}
		return verificador;
	}
	
	//Metodo para que lanze un mensaje despues de haber recibido los verificadores
	private static void verificadoresParaMSJ(boolean v1,boolean v2,boolean v3, boolean v4, boolean v5){
		if(v1==true && v2==true && v3==true && v4==true && v5==true){
			JOptionPane.showMessageDialog(null, "Nigun elemento ha sido modificado", "Sin cambios", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Metodos para actualizar valores de ceramicas
	private static void actualizarValoresM1(int i){
		if(i==1){
			Tienda.primerProd.precio=Double.parseDouble(txt1.getText());
		}
		if(i==2){
			Tienda.primerProd.ancho=Double.parseDouble(txt2.getText());
		}
		if(i==3){
			Tienda.primerProd.largo=Double.parseDouble(txt3.getText());
		}
		if(i==4){
			Tienda.primerProd.espesor=Double.parseDouble(txt4.getText());
		}
		if(i==5){
			Tienda.primerProd.contenido=Integer.parseInt(txt5.getText());
		}
		
		JOptionPane.showMessageDialog(null, "Cambios realizados con exito!","Cambios Hechos",JOptionPane.INFORMATION_MESSAGE);
		
	}
	private static void actualizarValoresM2(int i){
		if(i==1){
			Tienda.segundoProd.precio=Double.parseDouble(txt1.getText());
		}
		if(i==2){
			Tienda.segundoProd.ancho=Double.parseDouble(txt2.getText());
		}
		if(i==3){
			Tienda.segundoProd.largo=Double.parseDouble(txt3.getText());
		}
		if(i==4){
			Tienda.segundoProd.espesor=Double.parseDouble(txt4.getText());
		}
		if(i==5){
			Tienda.segundoProd.contenido=Integer.parseInt(txt5.getText());
		}
		JOptionPane.showMessageDialog(null, "Cambios realizados con exito!","Cambios Hechos",JOptionPane.INFORMATION_MESSAGE);
	}
	private static void actualizarValoresM3(int i){
		if(i==1){
			Tienda.tercerProd.precio=Double.parseDouble(txt1.getText());
		}
		if(i==2){
			Tienda.tercerProd.ancho=Double.parseDouble(txt2.getText());
		}
		if(i==3){
			Tienda.tercerProd.largo=Double.parseDouble(txt3.getText());
		}
		if(i==4){
			Tienda.tercerProd.espesor=Double.parseDouble(txt4.getText());
		}
		if(i==5){
			Tienda.tercerProd.contenido=Integer.parseInt(txt5.getText());
		}
		JOptionPane.showMessageDialog(null, "Cambios realizados con exito!","Cambios Hechos",JOptionPane.INFORMATION_MESSAGE);
	}
	private static void actualizarValoresM4(int i){
		if(i==1){
			Tienda.cuartoProd.precio=Double.parseDouble(txt1.getText());
		}
		if(i==2){
			Tienda.cuartoProd.ancho=Double.parseDouble(txt2.getText());
		}
		if(i==3){
			Tienda.cuartoProd.largo=Double.parseDouble(txt3.getText());
		}
		if(i==4){
			Tienda.cuartoProd.espesor=Double.parseDouble(txt4.getText());
		}
		if(i==5){
			Tienda.cuartoProd.contenido=Integer.parseInt(txt5.getText());
		}
		JOptionPane.showMessageDialog(null, "Cambios realizados con exito!","Cambios Hechos",JOptionPane.INFORMATION_MESSAGE);
	}
	private static void actualizarValoresM5(int i){
		if(i==1){
			Tienda.quintoProd.precio=Double.parseDouble(txt1.getText());
		}
		if(i==2){
			Tienda.quintoProd.ancho=Double.parseDouble(txt2.getText());
		}
		if(i==3){
			Tienda.quintoProd.largo=Double.parseDouble(txt3.getText());
		}
		if(i==4){
			Tienda.quintoProd.espesor=Double.parseDouble(txt4.getText());
		}
		if(i==5){
			Tienda.quintoProd.contenido=Integer.parseInt(txt5.getText());
		}
		JOptionPane.showMessageDialog(null, "Cambios realizados con exito!","Cambios Hechos",JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void actionPerformedCboModelo(ActionEvent arg0) {
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
	private void imprimir(double precio,double ancho,double largo,double espesor,int contenido){
		txtPrecio.setText(String.valueOf(precio));
		txtAncho.setText(String.valueOf(ancho));
		txtLargo.setText(String.valueOf(largo));
		txtEspesor.setText(String.valueOf(espesor));
		txtContenido.setText(String.valueOf(contenido));
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();
	}
}
