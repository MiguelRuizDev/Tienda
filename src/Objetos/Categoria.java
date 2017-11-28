package Objetos;

public class Categoria {

	private String cat;
	private String departamento;
	
	public Categoria(){
		this ("","");
	}
	
	public Categoria(String cat, String departamento) {
		this.cat = cat;
		this.departamento = departamento;
	}

	public String getCat() {
		return cat;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String insert(){
		
		return "INSERT INTO categoria VALUES ('"+cat+"','"+departamento+"')";
	}
	
	
	
}
