/**
 * 
 */
package com.muebles.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author dfnietop
 * 
 */
public class Conexion {
	private Connection conexion = null;

	public Conexion() {
		// TODO Auto-generated constructor stub
		crearConexion();
	}

	private static Conexion instance = null;

	public Connection crearConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/gerencia","root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;

	}

	public void cerrarConn() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Conexion getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new Conexion();
		}

	}

}
