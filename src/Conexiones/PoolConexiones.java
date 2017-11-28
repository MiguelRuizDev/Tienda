package Conexiones;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;



public class PoolConexiones {

	private static BasicDataSource dataSource=null;

	public static DataSource getDataSource()
	{
		if (dataSource == null)
		{
			dataSource = new BasicDataSource();

			String usuario = "root";
			String password = "";

			String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
			String puerto = "3306";
			String database = "Carrito";

			String driver = "com.mysql.jdbc.Driver";

			String ulrjdbc = "jdbc:mysql://" + host + ":" + puerto + "/" + database;

			// Ejemplo con base de datos MySQL
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(ulrjdbc);
			dataSource.setUsername(usuario);
			dataSource.setPassword(password);
			dataSource.setMaxActive(20); //MAXIMO DE CONEXIONES ACTIVAS
		}
		
		return dataSource;
		
	}
	
	public static Connection getConnection() 
	{
		Connection connection = null;
		
		try {
			connection = PoolConexiones.getDataSource().getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return connection;
	}
	
	public static void closeConnection (Connection connection)
	{
		if (null != connection)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
