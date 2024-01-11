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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JComboBox cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JTextField txtCant;
	private JButton btnVender;
	private JButton btnCerrar;
	private JTextArea txtS;
	
	//Declarar variables globales
	private double Precio,impCompra,impDesc,impPagar;
	private int Cant,cboNum,numObsq;
	private String Modelo,tipoObsequio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ventas dialog = new Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 10, 46, 14);
		contentPanel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
		cboModelo.setBounds(103, 7, 120, 20);
		contentPanel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 36, 83, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(103, 33, 120, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 62, 46, 14);
		contentPanel.add(lblCantidad);
		
		txtCant = new JTextField();
		txtCant.setBounds(103, 59, 120, 20);
		contentPanel.add(txtCant);
		txtCant.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(294, 27, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(294, 58, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 414, 160);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		cboModelo.setSelectedIndex(0);
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedCboModelo(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {//Boton vender
		capturarDatos(cboModelo,txtPrecio,txtCant);
		procesarDatos();
		contarVentas();
		imprimirDatos();
	}
	
	private void capturarDatos(JComboBox cbo, JTextField precio, JTextField cant){
		cboNum=cbo.getSelectedIndex();
		capturarModelo(cboNum);//generarReportes.java
		Precio=Double.parseDouble(precio.getText());
		Cant=Integer.parseInt(txtCant.getText());
		Modelo=cbo.getName();
	}
	
	private void procesarDatos(){
		impCompra=calcularImpCompra();
		impDesc=impDesc();
		impPagar=impPagar();
		numObsq=definirObsq();
	}
	
	private double calcularImpCompra(){
		return Precio*Cant;
	}
	
	private double definirDesc(){
		double desc=0;
		if(Cant<=5 && Cant>=1){
			desc=Tienda.porcentaje1;
		}
		else if(Cant>=6 && Cant<=10){
			desc=Tienda.porcentaje2;
		}
		else if(Cant>=11 && Cant<=15){
			desc=Tienda.porcentaje3;
		}
		else if(Cant>15){
			desc=Tienda.porcentaje4;
		}
		return desc;
	}
	
	private double impDesc(){
		double desc;
		desc=definirDesc();
		return impCompra*desc;
	}
	
	private double impPagar(){
		return impCompra-impDesc;
	}
	
	private int definirObsq(){
		int cantObsq=0;
		tipoObsequio="lapiceros";
		if(Cant<=5 && Cant>=1){
			cantObsq=Cant*Tienda.obsequioCantidad1;
		}
		else if(Cant>=6 && Cant<=10){
			cantObsq=Cant*Tienda.obsequioCantidad2;
		}
		else if(Cant>10){
			cantObsq=Cant*Tienda.obsequioCantidad3;
		}
		return cantObsq;
	}
	
	private void contarVentas(){
		Tienda.contNroVentas++;
		contarVentasParticulares();//GenerarReportes.java
		Tienda.contadorVentas+=impPagar;
		verificarContVentas(Tienda.contadorVentas);
	}
	
	private void verificarContVentas(double contadorVentas){
		String mensaje=" ";
		double porcCuotaDiaria=porcentajeCuotaDiaria();
		mensaje = "venta Nro. 5 \n"+"Importe total general acumulado: "+contadorVentas+"\n"+"Porcentaje de la cuota diaria: "+porcCuotaDiaria;
		if(Tienda.contNroVentas==5){
			imprimirMensajePopUp(mensaje);
		}
	}
	
	private void imprimirDatos(){
		txtS.setText("Boleta de Venta\n\n");
		txtS.append("Modelo              : "+cboModelo.getSelectedItem()+"\n");
		txtS.append("Precio                 : "+Tienda.primerProd.precio+"\n");
		txtS.append("Cantidad               : "+Integer.parseInt(txtCant.getText())+"\n");
		txtS.append("Importe de Compra      : "+"S/."+impCompra+"\n");
		txtS.append("Importe Descuento      : "+"S/."+impDesc+"\n");
		txtS.append("Importe Pagar          : "+"S/."+impPagar+"\n");
		txtS.append("Tipo de Obsequio       : "+Tienda.tipoObsequio+"\n");
		txtS.append("Unidades Obsequiadas   : "+numObsq+"\n");
		txtS.append("total venta: "+"S/."+Tienda.contadorVentas);
	}
	
	
	private void imprimirMensajePopUp(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double porcentajeCuotaDiaria(){
		return (Tienda.contadorVentas*100)/30000;
	}
	
	protected void actionPerformedCboModelo(ActionEvent arg0) {
		switch(cboModelo.getSelectedIndex()){
			case 0:  imprimir(Tienda.primerProd.precio);
					txtCant.setText("");
					break;
			case 1:  imprimir(Tienda.segundoProd.precio);
					txtCant.setText("");
					break;
			case 2:  imprimir(Tienda.tercerProd.precio);
					txtCant.setText("");
					break;
			case 3:  imprimir(Tienda.cuartoProd.precio);
					txtCant.setText("");
					break;
			case 4:  imprimir(Tienda.quintoProd.precio);
					txtCant.setText("");
					break;
		}
	}
	
	private void imprimir (double precio){
		txtPrecio.setText(String.valueOf(precio));
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();
	}
	//*_____________________________________________________________________________________________________________________*
	//Metodos que benefician a la clase generarReportes.java
	private void capturarModelo(int index){
		if(index==0){
			generarReportes.contProd1+=Integer.parseInt(txtCant.getText());//Para la cantidad de cajas vendidas
			generarReportes.contVentProd1++;//Para la cantidad de ventas
		}
		else if(index==1){
			generarReportes.contProd2+=Integer.parseInt(txtCant.getText());
			generarReportes.contVentProd2++;
		}
		else if(index==2){
			generarReportes.contProd3+=Integer.parseInt(txtCant.getText());
			generarReportes.contVentProd3++;
		}
		else if(index==3){
			generarReportes.contProd4+=Integer.parseInt(txtCant.getText());
			generarReportes.contVentProd4++;
		}
		else if(index==4){
			generarReportes.contProd5+=Integer.parseInt(txtCant.getText());
			generarReportes.contVentProd5++;
		}
	}
	
	private void contarVentasParticulares(){
		if(cboModelo.getSelectedIndex()==0){
			generarReportes.ttlVenProd1+=impPagar;
		}
		else if(cboModelo.getSelectedIndex()==1){
			generarReportes.ttlVenProd2+=impPagar;
		}
		else if(cboModelo.getSelectedIndex()==2){
			generarReportes.ttlVenProd3+=impPagar;
		}
		else if(cboModelo.getSelectedIndex()==3){
			generarReportes.ttlVenProd4+=impPagar;
		}
		else if(cboModelo.getSelectedIndex()==4){
			generarReportes.ttlVenProd5+=impPagar;
		}
	}
	//*_____________________________________________________________________________________________________________________*
}
