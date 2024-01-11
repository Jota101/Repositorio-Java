package Cibertec;

public class datosProductos {
	public String modelo;
	public double precio,ancho,largo,espesor;
	public int contenido;
	
	//Creamos el constructor
	public datosProductos(String modelo_,double precio_, double ancho_,double largo_,double espesor_,int contenido_){
		modelo=modelo_;
		precio=precio_;
		ancho=ancho_;
		largo=largo_;
		espesor=espesor_;
		contenido=contenido_;
	}
}
