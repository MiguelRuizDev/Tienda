package Objetos;


public class Producto {

	private String ref;
	private String description;
	private float pvp;
	private int stock;
	//private Categoria cat;
	private String cat;
	
	public Producto(){
		//this ("","",0,0,null);
		this ("","",0,0,"");
	}
	
	public Producto(String ref, String description, float pvp, int stock, String cat) {
		this.ref = ref;
		this.description = description;
		this.pvp = pvp;
		this.stock = stock;
		//this.cat = new Categoria(cat,"");
		this.cat = cat;
	}

	public String getRef() {
		return ref;
	}

	public String getDescription() {
		return description;
	}

	public float getPvp() {
		return pvp;
	}

	public int getStock() {
		return stock;
	}

	/*public Categoria getCat() {
		return cat;
	}*/

	public void setRef(String ref) {
		this.ref = ref;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/*public void setCat(Categoria cat) {
		this.cat = cat;
	}*/
	
	/*public void setKeyCat(String key){
		cat.setCat(key);
	}*/
	
	public String insert(){
		
		//return "INSERT INTO producto VALUES ('"+ref+"','"+description+"',"+pvp+","+stock+",'"+cat.getCat()+"')";
		return "INSERT INTO producto VALUES ('"+ref+"','"+description+"',"+pvp+","+stock+",'"+cat+"')";
		
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	
	
}
