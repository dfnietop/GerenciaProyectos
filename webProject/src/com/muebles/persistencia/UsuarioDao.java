package com.muebles.persistencia;

public class UsuarioDao {

	public void validarUsuario(Usuario us, Conexion conexion) {
		try {
			conexion.getInstance().crearConexion();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}

}
