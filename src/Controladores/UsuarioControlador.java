package Controladores;

import java.util.Scanner;

import Objetos.Usuario;

public class UsuarioControlador {

	private Usuario usuario;
	
	Scanner sc = new Scanner(System.in);
	
	public UsuarioControlador(){
		usuario = new Usuario("","",0,"","");
	}
	
	public UsuarioControlador(Usuario usuario){
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void leerNif(){
		
		System.out.println("Nif:");
		usuario.setNif(sc.nextLine());
	}
	
	public void leerResto(){
		
		System.out.println("Nombre:");
		usuario.setNombre(sc.nextLine());
		System.out.println("Login:");
		usuario.setLogin(sc.nextLine());
		System.out.println("Password:");
		usuario.setPassword(sc.nextLine());
		System.out.println("Saldo:");
		usuario.setSaldo(Float.parseFloat(sc.nextLine()));
	}
	
	public void leerDatos(){
		
		leerNif();
		leerResto();

		
	}
	
	public void restarSaldo(float total){
		
		usuario.setSaldo(usuario.getSaldo() - total);
	}
	
	
	public void subirSaldo(){
		Float recarga;
		
		System.out.println("Ingreso:");
		do{
			recarga = sc.nextFloat();
		}while(recarga < 0);
		
		Float total = usuario.getSaldo() + recarga;
		usuario.setSaldo(total);
	}
}
