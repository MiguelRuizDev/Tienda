package OpcionesMenu;

import java.util.Date;

import Controladores.CompraControlador;
import Controladores.ProductoControlador;
import Controladores.UsuarioControlador;
import DAO.CompraDAO;
import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import Objetos.Compra;
import Objetos.Producto;
import Objetos.Usuario;
import Vistas.CompraVista;
import Vistas.ProductoVista;
import Vistas.UsuarioVista;

public class HacerCompra implements MenuAction{
	
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
	
		
		Usuario usuario = new Usuario ();
		UsuarioControlador controladorU = new UsuarioControlador (usuario);
		UsuarioVista vistaU = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Producto producto = new Producto();
		ProductoControlador controladorP = new ProductoControlador(producto);
		ProductoVista vistaP = new ProductoVista(producto);
		ProductoDAO productoDAO = new ProductoDAO();
		
		controladorU.leerNif();
		
		usuario = usuarioDAO.findByKey(usuario.getNif());
		controladorU.setUsuario(usuario);
		vistaU.setUsuario(usuario);
		
		Date fecha = new Date(System.currentTimeMillis());
	
		if(usuario != null){
			
			boolean error = false;
			
			while(usuario.getSaldo() > 0 && !error){
				
				controladorP.leerRef();
				
				producto = productoDAO.findByKey(producto.getRef());
				controladorP.setProducto(producto);
				vistaP.setProducto(producto);
				
				if(producto != null){
					//PRODUCTO ENCONTRADO
					vistaP.mostrarStock();
					
					int cuantos = controladorP.leerCuantos();
					
					if(producto.getStock() >= cuantos){
						
						//PRODUCTO CON STOCK
						if(controladorP.calcularTotal(cuantos) <= usuario.getSaldo()){
							
							//DISPONE DE SALDO SUFICIENTE Y SE PUEDE REALIZAR LA COMPRA
							
							Compra compra = new Compra(usuario, producto, cuantos);
							CompraVista vistaC = new CompraVista(compra);
							CompraControlador controladorC = new CompraControlador(compra);
							CompraDAO compraDAO = new CompraDAO();
							
							controladorC.hacerCompra(usuario.getNif(), producto.getRef(), cuantos);
							if(compraDAO.insert(compra)){
								
								//LA COMPRA SE HA REALIZADO CON EXITO
								vistaC.mostrarSuccess();
								
								//RESTAMOS EL COSTE DE LA COMPRA AL USUARIO Y LA CANTIDAD AL STOCK
								controladorU.restarSaldo(controladorP.calcularTotal(cuantos));
								controladorP.restarStock(cuantos);
								
								//ACTUALIZAMOS LOS DATOS DE USUARIO Y PRODUCTO EN LA BBDD
								usuarioDAO.update(usuario);
								productoDAO.update(producto);
								
								if(!controladorC.continuarComprando()){
									
									//SI ES AFIRMATIVO SE REPITE EL PROCESO DE COMPRA, 
									//SI ES NEGATIVO SALTA LA BANDERA DE ERROR PARA TERMINAR EL BUCLE WHILE
									error = true;
								}
							}
							else{
								//ERROR AL ACCEDER A LA BASE DE DATOS
								vistaC.mostrarError();
								error = true;
							}
						}
						else{
							//NO DISPONE DE SALDO SUFICIENTE Y NO PUEDE REALIZAR LA COMPRA
							vistaU.mostrarFaltaSaldo();
							error = true;
						}
					}
					else{
						//NO HAY SUFICIENTES EN STOCK
						vistaP.mostrarFaltaStock();
						error = true;
					}
				}
				else{
					//PRODUCTO NO ENCONTRADO
					vistaP.mostrarFail();
					error = true;
				}

			}
		}
		else
			//USUARIO NO ENCONTRADO
			vistaU.mostrarFail();
			
	}
}
