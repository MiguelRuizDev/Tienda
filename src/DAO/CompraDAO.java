package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import Conexiones.ConexionManager;
import Conexiones.PoolConexiones;
import Objetos.Compra;



public class CompraDAO implements DAO <Compra, String>{

	@Override
	public boolean insert(Compra vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		
		//CONVERSION DE CLASE DATE A TIMESTAMP PARA METERSELA A NUESTRA BASE DE DATOS
		/*java.util.Date fecha = new java.util.Date();
		fecha = vo.getFecha();
		java.sql.Timestamp fechaTS = new java.sql.Timestamp(fecha.getTime());*/
		
	    try {
	    	
			    Connection poolConnection = PoolConexiones.getConnection();
			    poolConnection.setAutoCommit(false);
	            //Connection connection = ConexionManager.getConnection();
	            
	            // Se crea un Statement, para realizar la consulta
	            
	            String query = "INSERT INTO compra VALUES (?,?,?,?)";
	            PreparedStatement s = poolConnection.prepareStatement(query);
	            
	            s.setString(1, vo.getUsuario().getNif());
	            s.setString(2, vo.getProducto().getRef());
	            s.setTimestamp(3, new Timestamp(vo.getFecha().getTime()));
	            s.setInt(4, vo.getCantidad());

	            
	            cuantos = s.executeUpdate();   
	            
	           poolConnection.commit();
	           poolConnection.setAutoCommit(true);
	           
	           poolConnection.close();
	    }
	            
        catch (Exception e){
        	e.printStackTrace();
        }
	    /*finally{
	    	poolConnection.close();
	    }*/
	    

		return (cuantos == 1) ? true : false;
	}

	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		try {
			
			//LA VARIABLE DE ENTRADA KEY ES UNA CLAVE COMPUESTA POR LAS TRES PRIMARY KEYS DE LA TABLA COMPRA
			String[] claves = key.split("$");
			String nif = claves[0];
			String ref = claves[1];
			String fecha = claves[2];
		      
			Connection poolConnection = PoolConexiones.getConnection();
			//Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "DELETE compra WHERE nif = ? AND ref = ? AND fecha = ?";
            PreparedStatement s = poolConnection.prepareStatement(query);
            
            s.setString(1, nif);
            s.setString(2, ref);
            s.setString(3, fecha);
           
            
            cuantos = s.executeUpdate();       
	    }
	            
	    catch (Exception e){
	    	e.printStackTrace();
	    }
		
		return (cuantos == 1) ? true : false;
	}

	@Override
	public boolean update(Compra vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		try {
			
			//CONVERSION DE CLASE DATE A TIMESTAMP PARA METERSELA A NUESTRA BASE DE DATOS
			java.util.Date fecha = new java.util.Date();
			fecha = vo.getFecha();
			java.sql.Timestamp fechaTS = new java.sql.Timestamp(fecha.getTime());
		      
			Connection poolConnection = PoolConexiones.getConnection();
			//Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "UPDATE compra SET nif = ?, ref = ?, fecha = ?, cantidad = ?";
            PreparedStatement s = poolConnection.prepareStatement(query);
            
            s.setString(1, vo.getUsuario().getNif());
            s.setString(2, vo.getProducto().getRef());
            s.setTimestamp(3, fechaTS);
            s.setInt(4, vo.getCantidad());

            
            cuantos = s.executeUpdate();
		}
		
		catch (Exception e){
	    	e.printStackTrace();
	    }
		
		return (cuantos == 1) ? true : false;
	}

	@Override
	public Compra findByKey(String key) {
		// TODO Auto-generated method stub
		
		Compra compra = null;
		
		try {
			
			String[] claves = key.split("$");
			String nif = claves[0];
			String ref = claves[1];
			String fecha = claves[2];
			
			String query = "SELECT * FROM compra WHERE nif = ? AND ref = ? AND fecha = ?";
			
			Connection poolConnection = PoolConexiones.getConnection();
			
			PreparedStatement s = poolConnection.prepareStatement(query);
			
			s.setString(1, nif);
            s.setString(2, ref);
            s.setString(3, fecha);

			
			ResultSet result = s.executeQuery(query);
		

			compra = new Compra(result.getString(1),result.getString(2),new Date (result.getTimestamp(3).getTime()),result.getInt(4));
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compra;
	}

	@Override
	public Iterator<Compra> findAll() {
		// TODO Auto-generated method stub
		ArrayList <Compra> compras = new ArrayList();
		
		try {
			String query = "SELECT * FROM compra;";
			
			Connection poolConnection = PoolConexiones.getConnection();
			
			Statement s = poolConnection.createStatement();
			ResultSet result = s.executeQuery(query);
			
			//System.out.println(query);
			
			while (result.next()){
				

				Compra compra = new Compra(result.getString(1),result.getString(2),new Date (result.getTimestamp(3).getTime()),result.getInt(4));
				compras.add(compra);
				}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compras.iterator();
	}

}
