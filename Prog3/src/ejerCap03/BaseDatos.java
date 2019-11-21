package ejerCap03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

	private static Connection conexion;
	
	public static void abrirConexion( String nombreBD ) {

		System.out.println( "Conexión abierta" );
		try {
			Class.forName("org.sqlite.JDBC" );
			conexion = DriverManager.getConnection( "jdbc:sqlite:" + nombreBD );
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}
	
	public static void cerrarConexion() {
		try {
			if(conexion!=null) conexion.close();
			System.out.println("Cierre de base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error en base de datos");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * public static ArrayList<Producto> getProductos(){
	 * 
	 * try { ArrayList<Producto> ret = new ArrayList<Producto>(); Statement
	 * statement = conexion.createStatement(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	
}
