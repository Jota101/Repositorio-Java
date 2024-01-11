package Cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class generarReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoDeReporte;
	private JComboBox cboTipoRep;
	private JButton btnCerrar;
	
	//Declaracion variables globales
	public static int contProd1=0,contProd2=0,contProd3=0,contProd4=0,contProd5=0;//Para obtener el numero de cajas vendidas
	public static int contVentProd1=0,contVentProd2=0,contVentProd3=0,contVentProd4=0,contVentProd5=0;//Para el numero de ventas de cada modelo
	public static double ttlVenProd1=0,ttlVenProd2=0,ttlVenProd3=0,ttlVenProd4=0,ttlVenProd5=0;
	private String mensaje1,mensaje2,mensaje3,mensaje4,mensaje5;
	private double aporteCD1=0,aporteCD2=0,aporteCD3=0,aporteCD4=0,aporteCD5=0;
	private int cbo;
	private double precioProd1=Tienda.primerProd.precio,precioProd2=Tienda.segundoProd.precio,precioProd3=Tienda.tercerProd.precio,precioProd4=Tienda.cuartoProd.precio,precioProd5=Tienda.quintoProd.precio;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			generarReportes dialog = new generarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public generarReportes() {
		setBounds(100, 100, 506, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de Reporte");
		lblTipoDeReporte.setBounds(10, 25, 91, 14);
		contentPanel.add(lblTipoDeReporte);
		
		cboTipoRep = new JComboBox();
		cboTipoRep.addActionListener(this);
		cboTipoRep.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Comparacion de precios con el precio promedio", "Comparacion de caja vendidas con la cantidad optima", "Estadistica sobre el precio"}));
		cboTipoRep.setBounds(109, 22, 278, 20);
		contentPanel.add(cboTipoRep);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(397, 21, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 471, 181);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboTipoRep) {
			actionPerformedCboTipoRep(arg0);
		}
	}
	protected void actionPerformedCboTipoRep(ActionEvent arg0) {
		//Recibir el indice para conocer que tipo de reporte desea el usuario
		reconocerIndexCBO();
	}
	
	private void reconocerIndexCBO(){
		switch(cboTipoRep.getSelectedIndex()){
			case 0: procesoVentMod();
					imprimirRepVentasMod();
					break;
					
			case 1: imprimirPrecioProm();
					break;
					
			case 2: imprimirCajaVendCantOptm();
					break;
					
			case 3: imprimirEstPrecio();
					break;
		}
	}
	
	//Metodos de impresion
	private void imprimirRepVentasMod(){
		txtS.setText("Ventas por Modelo\n\n");
		mensajeRepVent(Tienda.primerProd.modelo,contVentProd1,contProd1,ttlVenProd1,mensaje1);
		mensajeRepVent(Tienda.segundoProd.modelo,contVentProd2,contProd2,ttlVenProd2,mensaje2);
		mensajeRepVent(Tienda.tercerProd.modelo,contVentProd3,contProd3,ttlVenProd3,mensaje3);
		mensajeRepVent(Tienda.cuartoProd.modelo,contVentProd4,contProd4,ttlVenProd4,mensaje4);
		mensajeRepVent(Tienda.quintoProd.modelo,contVentProd5,contProd5,ttlVenProd5,mensaje5);
	}
	
	private void imprimirPrecioProm(){
		txtS.setText("Comparacion de precios con el precio promedio\n\n");
		mensajePreProm(Tienda.primerProd.modelo, Tienda.primerProd.precio, verificarMasMenosProm(Tienda.primerProd.precio));
		mensajePreProm(Tienda.segundoProd.modelo,Tienda.segundoProd.precio, verificarMasMenosProm(Tienda.segundoProd.precio));
		mensajePreProm(Tienda.tercerProd.modelo,Tienda.tercerProd.precio, verificarMasMenosProm(Tienda.tercerProd.precio));
		mensajePreProm(Tienda.cuartoProd.modelo,Tienda.cuartoProd.precio, verificarMasMenosProm(Tienda.cuartoProd.precio));
		mensajePreProm(Tienda.quintoProd.modelo,Tienda.quintoProd.precio, verificarMasMenosProm(Tienda.quintoProd.precio));
	}
	
	private void imprimirCajaVendCantOptm(){
		txtS.setText("Comparación de cajas vendidas con la cantidad óptima\n\n");
		mensajeCompCajasVend(Tienda.primerProd.modelo, contProd1, verificarMasMenosCompCajas(contProd1));
		mensajeCompCajasVend(Tienda.segundoProd.modelo, contProd2, verificarMasMenosCompCajas(contProd2));
		mensajeCompCajasVend(Tienda.tercerProd.modelo, contProd3, verificarMasMenosCompCajas(contProd3));
		mensajeCompCajasVend(Tienda.cuartoProd.modelo, contProd4, verificarMasMenosCompCajas(contProd4));
		mensajeCompCajasVend(Tienda.quintoProd.modelo, contProd5, verificarMasMenosCompCajas(contProd5));
		
	}
	
	private void imprimirEstPrecio(){
		txtS.setText("Estadistica sobre el precio \n\n");
		txtS.append("Precio promedio: "+calcularPrecioProm()+"\n");
		txtS.append("Precio mayor: "+calcularPrecioMayor()+"\n");
		txtS.append("Precio menor: "+calcularPrecioMenor());
	}
	//*____________________________________________________________________________________________________________________*
	//Metodos de calculos de ventas por modelo
	private void procesoVentMod(){
		calcularAporteCuotaDiaria();
	}
	private void calcularAporteCuotaDiaria(){
		boolean ver1=false,ver2=false,ver3=false,ver4=false,ver5=false;
		
		//Calculo aporte producto 1
		ver1=verificarMonto(ttlVenProd1); //Verificar si el total de ventas de cada producto es diferentes de 0
		procesarRpta1(ver1);
		
		//Calculo aporte producto 2
		ver2=verificarMonto(ttlVenProd2);
		procesarRpta2(ver2);
		
		//Calculo aporte producto 3
		ver3=verificarMonto(ttlVenProd3);
		procesarRpta3(ver3);
		
		//Calculo aporte producto 4
		ver4=verificarMonto(ttlVenProd4);
		procesarRpta4(ver4);
		
		//Calculo aporte producto 5
		ver5=verificarMonto(ttlVenProd5);
		procesarRpta5(ver5);
	}
	private boolean verificarMonto(double totalVenta){
		boolean verificador=false;
		if(totalVenta!=0){
			verificador =true;
		}
		else{
			verificador=false;
		}
		
		return verificador;
	}
	private void procesarRpta1(boolean verificador){
		if(verificador==true){
			aporteCD1=(ttlVenProd1*100)/30000;
			mensaje1=String.valueOf(aporteCD1);			
		}
		else if(verificador==false){
			mensaje1="Valor no definido";
		}
	}
	private void procesarRpta2(boolean verificador){
		if(verificador==true){
			aporteCD2=(ttlVenProd2*100)/30000;
			mensaje2=String.valueOf(aporteCD2);			
		}
		else if(verificador==false){
			mensaje2="Valor no definido";
		}
	}
	private void procesarRpta3(boolean verificador){
		if(verificador==true){
			aporteCD3=(ttlVenProd3*100)/30000;
			mensaje3=String.valueOf(aporteCD3);			
		}
		else if(verificador==false){
			mensaje3="Valor no definido";
		}
	}
	private void procesarRpta4(boolean verificador){
		if(verificador==true){
			aporteCD4=(ttlVenProd4*100)/30000;
			mensaje4=String.valueOf(aporteCD4);			
		}
		else if(verificador==false){
			mensaje4="Valor no definido";
		}
	}
	private void procesarRpta5(boolean verificador){
		if(verificador==true){
			aporteCD5=(ttlVenProd5*100)/30000;
			mensaje5=String.valueOf(aporteCD5);			
		}
		else if(verificador==false){
			mensaje5="Valor no definido";
		}
	}
	
	private void mensajeRepVent(String modelo, int contVentProd, int contProd, double ttlVenProd, String mensaje ){
		txtS.append("Modelo: "+modelo+"\n");
		txtS.append("Cantidad de ventas: "+contVentProd+"\n");
		txtS.append("Cantidad de cajas vendidas: "+contProd+"\n");
		txtS.append("Importe total vendido: "+"S/."+ttlVenProd+"\n");
		txtS.append("Aporte a la cuota Diaria: "+mensaje+"%"+"\n\n");
	}
	
	//*____________________________________________________________________________________________________________________*
		//Metodos de calculos de Comparación de precios con el precio promedio
	private double calcularPrecioProm()
	{
		return (Tienda.primerProd.precio+Tienda.segundoProd.precio+Tienda.tercerProd.precio+Tienda.cuartoProd.precio+Tienda.quintoProd.precio)/5;
	}
	
	private  String verificarMasMenosProm(double precio){
		String comparacion="";
		double calculo=0,precioProm=calcularPrecioProm();
	
		if(precio<precioProm){
			calculo=precioProm-precio;
			comparacion=calculo+" menos que el promedio";
		}
		else if(precio>precioProm){
			calculo=precio-precioProm;
			comparacion=calculo+" mas que el promedio";
		}
		return comparacion;
	}
	private void mensajePreProm(String modelo, double precio,String comparacion){
		txtS.append("Modelo: "+modelo+"\n");
		txtS.append("precio: "+precio+"\n");
		txtS.append("Precio promedio: "+calcularPrecioProm()+"\n");
		txtS.append("comparacion: "+comparacion+"\n\n");
	}
	//*____________________________________________________________________________________________________________________*
	
	//*____________________________________________________________________________________________________________________*
			//Metodos de calculos de Comparación de cajas vendidas con la cantidad óptima
	private String verificarMasMenosCompCajas(int cant){
		int cantOpt=Tienda.cantidadOptima;
		int calculo=0;
		String comparacion="";
		if(cant==cantOpt){
			comparacion=" igual que la cantidad";
		}
		else if(cant<cantOpt){
			calculo=cantOpt-cant;
			comparacion= calculo+" menos que la cantidad optima";
		}
		else if(cant>cantOpt){
			calculo=cant-cantOpt;
			comparacion=calculo+" mas que la cantidad optima";
		}
		
		return comparacion;
	}

	private void mensajeCompCajasVend(String modelo, int cajasVend, String comparacion){
		txtS.append("Modelo: "+modelo+"\n");
		txtS.append("Cantidad de cajas vendidas: "+cajasVend+"\n");
		txtS.append("Cantidad Optima: "+Tienda.cantidadOptima+"\n");
		txtS.append("comparacion: "+comparacion+ "\n\n");
	}
	//*____________________________________________________________________________________________________________________*
	
	//*____________________________________________________________________________________________________________________*
	//Metodos de calculos de Estadística sobre el precio
	private double calcularPrecioMayor(){
		double pre=0;
		double menor=0;
		double mayor=0;
		for(int i=0;i<5;i++){
			if(i==0)pre=precioProd1;
			else if(i==1) pre=precioProd2;
			else if(i==2) pre=precioProd3;
			else if(i==3) pre=precioProd4;
			else if(i==4) pre=precioProd5;
			if(menor>pre || menor==0) menor=pre;
			if(mayor<pre) mayor=pre;
		}
		return mayor;
	}
	
	private double calcularPrecioMenor(){
		double pre=0;
		double menor=0;
		double mayor=0;
		for(int i=0;i<5;i++){
			if(i==0)pre=precioProd1;
			else if(i==1) pre=precioProd2;
			else if(i==2) pre=precioProd3;
			else if(i==3) pre=precioProd4;
			else if(i==4) pre=precioProd5;
			if(menor>pre || menor==0) menor=pre;
			if(mayor<pre) mayor=pre;
		}
		return menor;
	}
	//*____________________________________________________________________________________________________________________*
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();
	}
}
