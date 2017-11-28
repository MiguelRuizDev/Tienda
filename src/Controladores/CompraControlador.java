package Controladores;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import Objetos.Compra;

public class CompraControlador {
	
private Compra compra;
	
	Scanner sc = new Scanner(System.in);

	public CompraControlador(){
		compra = null;
	}
	
	public CompraControlador(Compra compra){
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public void hacerCompra(String nif, String ref, int cuantos){
		
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		
		this.compra = new Compra(nif, ref, date, cuantos);

	}
	
	public boolean continuarComprando(){
		
		boolean resultado = false; //PARTIMOS DE QUE NO DESEA COMPRAR MAS
		int respuesta;
		
		System.out.println("\nDeseas seguir comprando? Introduce 1 para continuar, 2 para salir\n");
		respuesta = sc.nextInt();
		
		if(respuesta == 1)
			resultado = true; //EL CLIENTE DESEA SEGUIR COMPRANDO
	
		return resultado;
	}
	
	public void leerDatos(){
		
		//Pendiente de formulario
		
	}

}
