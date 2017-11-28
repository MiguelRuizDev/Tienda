package Vistas;

import Objetos.Producto;

public class ProductoVista {
	
	private Producto producto;
	
	public ProductoVista(){
		producto = null;
	}
	
	public ProductoVista(Producto producto){
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void mostrarEnConsola(){
		System.out.println("Ref:\t" + producto.getRef());
		System.out.println("Descripcion:\t" + producto.getDescription());
		System.out.println("Pvp:\t" + producto.getPvp());
		System.out.println("Stock:\t" + producto.getStock());
		System.out.println("Categoria:\t" + producto.getCat());
	}
	
	public void mostrarProducto(){
		System.out.println(producto.toString());
	}
	
	public void mostrarEnHTML(){
		//HACER HTML
	}
	
	public void mostrarYaRegistrado(){
		System.out.println("El producto con Ref. " + producto.getRef() + " ya ha sido registrado");
	}
	
	public void mostrarError(){
		System.out.println("\nError insertando producto\n");
	}
	
	public void mostrarSuccess(){
		System.out.println("\nProducto guardado en el almacen\n");
		
	}
	
	public void mostrarFail(){
		System.out.println("\nProducto no encontradon\n");
		
	}
	public void mostrarFaltaStock(){
		System.out.println("\nProducto sin existencias\n");
		
	}
	
	public void mostrarStock(){
		System.out.println("\nQuedan " + producto.getStock() +" en stock\n");
	}

}
