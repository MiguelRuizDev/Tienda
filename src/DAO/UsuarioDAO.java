package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Conexiones.ConexionManager;
import Conexiones.PoolConexiones;
import Objetos.Usuario;
import Vistas.UsuarioVista;


public class UsuarioDAO implements DAO<Usuario, String> {

	@Override
	public boolean insert(Usuario vo) {
		// TODO Auto-generated method stub

		int cuantos = 0;
		
	    try {
	    		Connection poolConnection = PoolConexiones.getConnection(); 
	            //Connection connection = ConexionManager.getConnection();
	            
	            // Se crea un Statement, para realizar la consulta
	            
	            String query = "INSERT INTO usuario VALUES (?,?,?,?,?)";
	            PreparedStatement s = poolConnection.prepareStatement(query);
	            
	            s.setString(1, vo.getNif());
	            s.setString(2, vo.getNombre());
	            s.setFloat(3, vo.getSaldo());
	            s.setString(4, vo.getLogin());
	            s.setString(5, vo.getPassword());
	            
	            cuantos = s.executeUpdate();  
	            
	            PoolConexiones.closeConnection(poolConnection);
	    }
	            
        catch (Exception e){
        	//e.printStackTrace();
        	System.out.println("Error en la base de datos");
        }
	            
        		
		
		return (cuantos == 1) ? true : false;
	}

	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		
		int cuantos = 0;
		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "DELETE usuario WHERE nif = ?";
            PreparedStatement s = connection.prepareStatement(query);
            
            s.setString(1, key);

            
            cuantos = s.executeUpdate();       
	    }
	            
	    catch (Exception e){
	    	//e.printStackTrace();
	    	System.out.println("Error en la base de datos");
	    }
		
		return (cuantos == 1) ? true : false;
		
	}

	@Override
	public boolean update(Usuario vo) {
		// TODO Auto-generated method stub
		
		int cuantos = 0;
		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "UPDATE usuario SET nombre = ?, saldo = ?, login = ?, pass = ? WHERE nif = ?";
            PreparedStatement s = connection.prepareStatement(query);
            
            s.setString(5, vo.getNif());
            s.setString(1, vo.getNombre());
            s.setFloat(2, vo.getSaldo());
            s.setString(3, vo.getLogin());
            s.setString(4, vo.getPassword());
            
            cuantos = s.executeUpdate();       
	    }
	       
		catch (Exception e){
	    	//e.printStackTrace();
			System.out.println("Error en la base de datos");
	    }
		
		return (cuantos == 1) ? true : false;
	    
	}

	@Override
	public Usuario findByKey(String key) {
		// TODO Auto-generated method stub
		
		Usuario user = null;
		
		try {
			
			String query = "SELECT * FROM usuario WHERE nif = "+ key +";";
			
			PreparedStatement s = ConexionManager.getConnection().prepareStatement(query);
			
			ResultSet result = s.executeQuery(query);
			
			//s.setString(1, key);
			
			
			if(result.next()){
				
				user = new Usuario(result.getString(1),result.getString(2),result.getFloat(3),result.getString(4),result.getString(5));
				//System.out.println(user.toString());
			
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la base de datos");
		}
		return user;
	}

	@Override
	public Iterator<Usuario> findAll() {
		// TODO Auto-generated method stub
		
		ArrayList <Usuario> usuarios = new ArrayList();
		
		try {
			String query = "SELECT * FROM usuario;";
			Statement s = ConexionManager.getConnection().createStatement();
			ResultSet result = s.executeQuery(query);
			
			//System.out.println(query);
			
			while (result.next()){
			     
				Usuario user = new Usuario(result.getString(1),result.getString(2),result.getFloat(3),result.getString(4),result.getString(5));
				usuarios.add(user);
				}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios.iterator();
	}

}
