package Objetos;


import java.sql.Timestamp;
import java.util.Date;

public class Compra {
	
	private Producto producto;
	private Usuario usuario;
	private Date fecha;
	private int cantidad;
	
	public Compra(){
		this (null,null,null,0);
	}
	
	public Compra(String nif, String ref, Date date, int cantidad) {
		
		usuario = new Usuario();
		usuario.setNif(nif);
		
		producto = new Producto();
		producto.setRef(ref);
		
		fecha = date;
		
		this.cantidad = cantidad;
	}
	
	public Compra(Usuario usuario, Producto producto, int cantidad) {
		this.producto = producto;
		
		this.usuario = usuario;
		
		fecha = new Date(System.currentTimeMillis());
		
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setFecha(Date fecha) {
		
		this.fecha = fecha;
		//LA FECHA SE QUEDA CON FORMATO YYYY-MM-DD
		
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public String getClaves(){
		
		String claves = usuario.getNif() + "$" + producto.getRef() + "$" + getFecha();
		
		return claves;
	}

	@Override
	public String toString() {
		return "Compra [producto=" + producto.getRef() + ", usuario=" + usuario.getNif() + ", fecha=" + fecha + ", cantidad=" + cantidad
				+ "]";
	}
	
	
	

}
