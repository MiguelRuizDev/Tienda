package Vistas;

import Objetos.Compra;

public class CompraVista {

	private Compra compra;
	
	public CompraVista(Compra compra){
		this.compra = compra;
	}
	
	public void mostrarSuccess(){
		System.out.println("\nCompra realizada\n");
	}
	
	public void mostrarError(){
		System.out.println("\nError al hacer la compra\n");
	}

	public void mostrarFaltaDeSaldo(){
		System.out.println("\nNo tienes suficiente saldo\n");
	}
	
	public void mostrarFaltaDeStock(){
		System.out.println("\nNo hay suficiente stock\n");
	}
}
