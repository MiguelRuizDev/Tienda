package App;

import OpcionesMenu.MenuItem;
import OpcionesMenu.Salir;
import OpcionesMenu.SubirSaldo;
import OpcionesMenu.AppMenu;
import OpcionesMenu.HacerCompra;
import OpcionesMenu.InsertarProducto;
import OpcionesMenu.InsertarUsuario;

public class Aplicacion extends AppMenu{
	
	public Aplicacion(){
		
		addOpcion (new MenuItem ("Insertar Usuario", 1, new InsertarUsuario()));
		addOpcion (new MenuItem ("Insertar Producto", 2, new InsertarProducto()));
		addOpcion (new MenuItem ("Hacer Compra", 3, new HacerCompra()));
		addOpcion (new MenuItem ("Incrementar Saldo", 4, new SubirSaldo()));
		addOpcion (new Salir());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aplicacion app = new Aplicacion();
		
		app.run();
	}

}
