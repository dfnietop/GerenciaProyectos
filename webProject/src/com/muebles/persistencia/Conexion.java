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
	private String ususario;
	private String pass;
	private String url;
	private String bd;
	private Connection conexion = null;

	public Conexion() {
		// TODO Auto-generated constructor stub
		crearConexion();
	}

	private static Conexion instance = null;

	public Connection crearConexion() {

		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream(
					"/PersistenceResource.properties"));

			this.bd = propiedades.getProperty("bd");
			this.url = propiedades.getProperty("url");
			this.pass = propiedades.getProperty("pass");
			this.ususario = propiedades.getProperty("usuario");

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://" + url + "/"
					+ bd, ususario, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
