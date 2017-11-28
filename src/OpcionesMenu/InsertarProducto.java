package OpcionesMenu;

import Controladores.ProductoControlador;
import DAO.ProductoDAO;
import Objetos.Producto;
import Vistas.ProductoVista;

public class InsertarProducto implements MenuAction {

	public InsertarProducto(){
		
	}
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		Producto producto = new Producto();
		ProductoControlador controlador = new ProductoControlador(producto);
		ProductoVista vista = new ProductoVista(producto);
		ProductoDAO productoDAO = new ProductoDAO(); 
		
		controlador.leerRef();
				
		if(productoDAO.findByKey(producto.getRef()) == null){	
		
			controlador.leerResto();
			
			if (productoDAO.insert(producto)){
				vista.mostrarSuccess();
				vista.mostrarEnConsola();
			}
			else
				vista.mostrarError();
		}
		else
			vista.mostrarYaRegistrado();
	}

}
