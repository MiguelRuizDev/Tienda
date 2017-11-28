package Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionManager {
	
	   private static Connection connection=null;
	   
	   public static Connection getConnection() 
	   {
		 if (connection == null)
		 {
		   String usuario = "root";
	        String password = "";
	 
	        String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
	        String puerto = "3306";
	        String database = "Carrito";
	 
	        String driver = "com.mysql.jdbc.Driver";
	        
	 
	        String ulrjdbc = "jdbc:mysql://" + host + ":" + puerto + "/" + database;
	 
	     
	        try {
	            Class.forName(driver).newInstance();
	            connection = DriverManager.getConnection(ulrjdbc, usuario, password);
	            
	            //System.out.println("Conectionesfull");
	         }
	     
	     catch(ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex)
	        {
	        ex.printStackTrace();
	     	}
		 }  
	     return connection;
	   }
	   
	   public static void  close ()
	   {
		   if (connection != null)
		   {
			   try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
			   
	
	   }

}
