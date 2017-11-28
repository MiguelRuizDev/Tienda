package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import Conexiones.ConexionManager;
import Conexiones.PoolConexiones;
import Objetos.Producto;



public class ProductoDAO implements DAO<Producto, String>{

	@Override
	public boolean insert(Producto vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
	    try {
			      
	    	Connection poolConnection = PoolConexiones.getConnection();   
	    	//Connection connection = ConexionManager.getConnection();
	            
            // Se crea un Statement, para realizar la consulta
            
            String query = "INSERT INTO producto VALUES (?,?,?,?,?)";
            PreparedStatement s = poolConnection.prepareStatement(query);
            
            s.setString(1, vo.getRef());
            s.setString(2, vo.getDescription());
            s.setFloat(3, vo.getPvp());
            s.setInt(4, vo.getStock());
            s.setString(5, vo.getCat());
            
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
            
            String query = "DELETE producto WHERE ref = ?";
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
	public boolean update(Producto vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "UPDATE producto SET descripcion = ?, pvp = ?, stock = ?, cat = ? WHERE ref = ?";
            PreparedStatement s = connection.prepareStatement(query);
            
            s.setString(5, vo.getRef());
            s.setString(1, vo.getDescription());
            s.setFloat(2, vo.getPvp());
            s.setInt(3, vo.getStock());
            s.setString(4, vo.getCat());
            
            cuantos = s.executeUpdate();       
	    }
	            
	    catch (Exception e){
	    	//e.printStackTrace();
	    	System.out.println("Error en la base de datos");
	    }
		
		return (cuantos == 1) ? true : false;
	}

	@Override
	public Producto findByKey(String key) {
		// TODO Auto-generated method stub
		
		Producto producto = null;
		
		try {
			
			String query = "SELECT * FROM producto WHERE ref = "+ key +";";
			
			PreparedStatement s = ConexionManager.getConnection().prepareStatement(query);
			
			//s.setString(1, key);
			
			ResultSet result = s.executeQuery(query);
		
						     
			if(result.next())
				producto = new Producto(result.getString(1),result.getString(2),result.getFloat(3),result.getInt(4),result.getString(5));
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error en la base de datos");
		}
		return producto;
	}

	@Override
	public Iterator<Producto> findAll() {
		// TODO Auto-generated method stub
		
		ArrayList <Producto> productos = new ArrayList();
		
		try {
			String query = "SELECT * FROM producto;";
			Statement s = ConexionManager.getConnection().createStatement();
			ResultSet result = s.executeQuery(query);
			
			//System.out.println(query);
			
			while (result.next()){
				Producto producto = new Producto(result.getString(1),result.getString(2),result.getFloat(3),result.getInt(4),result.getString(5));
				productos.add(producto);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error en la base de datos");
		}
		return productos.iterator();
	
	}

}
