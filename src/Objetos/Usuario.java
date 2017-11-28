package Objetos;


public class Usuario {
	private String nif;
	private String nombre;
	private float saldo;
	private String login;
	private String password;
	
	public Usuario() {
		this("","",0,"","");
	}

	public Usuario(String nif, String nombre, float saldo, String login, String password) 
	{
		this.nif = nif;
		this.nombre = nombre;
		this.saldo = saldo;
		this.login = login;
		this.password = password;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nif=" + nif + ", nombre=" + nombre + ", saldo=" + saldo + ", login=" + login + ", password="
				+ password + "]";
	}
	
}
