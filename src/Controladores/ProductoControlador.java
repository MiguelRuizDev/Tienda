package Controladores;

import java.util.Scanner;

import Objetos.Producto;
import daw.com.Teclado;

public class ProductoControlador {
	
	private Producto producto;
	
	Scanner sc = new Scanner(System.in);

	public ProductoControlador(){
		producto = new Producto ("","",0,0,"");
	}
	
	public ProductoControlador(Producto producto){
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void leerRef(){
		
		System.out.println("Ref:");
		
		producto.setRef(Teclado.leerString());
	}
	
	public void leerResto(){
		
		System.out.println("Descripcion:");
		producto.setDescription(sc.nextLine());
		System.out.println("Pvp:");
		producto.setPvp(Float.parseFloat(sc.nextLine()));
		System.out.println("Stock:");
		producto.setStock(Integer.parseInt(sc.nextLine()));
		System.out.println("Categoria:");
		producto.setCat(sc.nextLine());
	}
	
	public void leerDatos(){
		leerRef();
		leerResto();
	}
	
	public int leerCuantos(){
		int cuantos;
		System.out.println("Cuantos desea comprar?");
		
		do{
			cuantos = sc.nextInt();
		}while(cuantos < 1);
		
		return cuantos;
	}
	
	public float calcularTotal(int cuantos){
		
		float total = cuantos * producto.getPvp();
		
		return total;
	}
	
	public void restarStock(int cuantos){
		producto.setStock(producto.getStock() - cuantos);
	}
}
