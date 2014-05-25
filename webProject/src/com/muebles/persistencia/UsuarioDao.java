package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.Statement;

public class UsuarioDao {

	public void validarUsuario(Usuario us) {
		Conexion conexion = new Conexion();
		try {
			
			conexion.getInstance().crearConexion();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
	
	public void guardar(Usuario usuario) {  
		Conexion conexion = new Conexion();
		try {   
			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();   
			
			String sql = "INSERT INTO GERENCIA.USUARIOS ( USUARIO, PASSWORD, NOMBRES, APELLIDOS, EMAIL) VALUES ("+usuario.getUsuario()+","+usuario.getPassword()+","+usuario.getNombres()+","+usuario.getApellidos()+","+usuario.getEmail()+")";
			
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}
		
	}

}
