package OpcionesMenu;

import java.util.Scanner;

import Controladores.UsuarioControlador;
import DAO.UsuarioDAO;
import Objetos.Usuario;
import Vistas.UsuarioVista;

public class SubirSaldo implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario ();
		UsuarioControlador controlador = new UsuarioControlador (usuario);
		UsuarioVista vista = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		controlador.leerNif();
		
		//usuario = new Usuario(usuarioDAO.findByKey(usuario.getNif()));
		usuario = usuarioDAO.findByKey(usuario.getNif());
		
		//System.out.println(usuario.toString());
		
		if(usuario != null){
			
			controlador.setUsuario(usuario);
			
			vista.setUsuario(usuario);
			
			vista.mostrarSaldo();
			
			
			controlador.subirSaldo();
			
			if(usuarioDAO.update(usuario)){
				vista.mostrarSubidaSaldo();
				usuarioDAO.update(usuario);
			}
			else
				vista.mostrarError();
			
		}
		else
			vista.mostrarNoRegistrado();
		
		
	}

}
