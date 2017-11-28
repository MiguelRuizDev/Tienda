package Vistas;

import Objetos.Usuario;

public class UsuarioVista {

	private Usuario usuario;
	
	public UsuarioVista(){
		usuario = null;
	}
	
	public UsuarioVista(Usuario usuario){
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void mostrarEnConsola(){
		System.out.println("Nif:\t" + usuario.getNif());
		System.out.println("Nombre:\t" + usuario.getNombre());
		System.out.println("Saldo:\t" + usuario.getSaldo());
		System.out.println("Login:\t" + usuario.getLogin());
		System.out.println("Password:\t" + usuario.getPassword());
	}
	
	public void mostrarUsuario(){
		System.out.println(usuario.toString());
	}
	
	public void mostrarSaldo(){
		System.out.println("Saldo:\t" + usuario.getSaldo());
	}
	
	public void mostrarSubidaSaldo(){
		System.out.println("Saldo nuevo:" + usuario.getSaldo());
	}

	public void mostrarEnHTML(){
		//HACER HTML
	}
	
	public void mostrarYaRegistrado(){
		System.out.println("El usuario con nif " + usuario.getNif() + " ya existe");
	}
	
	public void mostrarNoRegistrado(){
		System.out.println("El usuario no existe");
	}
	
	public void mostrarError(){
		System.out.println("Error en la base de datos");
	}
	
	public void mostrarSuccess(){
		System.out.println("Usuario dado de alta");
		
	}
	
	public void mostrarFail(){
		System.out.println("Usuario no encontrado en la base de datos");
		
	}
	
	public void mostrarFaltaSaldo(){
		System.out.println("\nUsuario sin saldo suficuente. Por favor recargue su saldo\n");
		
	}
	
	
	
	
}
