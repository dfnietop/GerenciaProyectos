/**
 * LoginBean.java
 * 
 */

package com.muebles.seguridad;

import com.muebles.persistencia.Conexion;
import com.muebles.persistencia.Usuario;
import com.muebles.persistencia.UsuarioDao;

public class LoginBean {
	private String name;
	private String password;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public void validar() {   
		Usuario us = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		us.setNombres(this.name);
		us.setPassword(this.password);
		dao.validarUsuario(us);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
