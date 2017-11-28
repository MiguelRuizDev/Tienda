package OpcionesMenu;

import java.util.Scanner;

import Controladores.UsuarioControlador;
import DAO.UsuarioDAO;
import Objetos.Usuario;
import Vistas.UsuarioVista;

public class InsertarUsuario implements MenuAction {
	

	@Override
	public void doMenuAction() { 
		
		Usuario usuario = new Usuario ();
		UsuarioControlador controlador = new UsuarioControlador (usuario);
		UsuarioVista vista = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		controlador.leerNif();
		
		
		if(usuarioDAO.findByKey(usuario.getNif()) == null){
			
			controlador.leerResto();
		
			if (usuarioDAO.insert(usuario)){
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
