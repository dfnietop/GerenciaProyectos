/**
 * LoginBean.java
 * 
 */

package com.muebles.seguridad;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;

import com.muebles.persistencia.InmueblesDao;
import com.muebles.persistencia.Usuario;
import com.muebles.persistencia.UsuarioDao;

@RequestScoped
public class LoginBean {
	private static int id;
	private String name;
	private String user;
	private String password;
	private String mensaje;
	private boolean render = false;
	Usuario usua = new Usuario();

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public void validar(ActionEvent event) {
		if (event.getComponent().getId().equals("validarId")) {
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context
						.getExternalContext().getResponse();
				Usuario us = new Usuario();
				UsuarioDao dao = new UsuarioDao();
				us.setUsuario(this.user);
				us.setPassword(this.password);
				if ((!this.user.isEmpty()) || (!this.user.equals(""))) {
					if ((!this.password.isEmpty())
							|| (!this.password.equals(""))) {
						if (dao.validarUsuario(us)) {
							ArrayList inmuebles = new ArrayList();
							InmueblesDao inmuebledao = new InmueblesDao();

							inmuebles = inmuebledao.consultarInmueble(id);
							id = us.getId();

							response.sendRedirect("/webProject/faces/welcome.xhtml");
						} else {
							response.sendRedirect("/webProject/faces/login.xhtml");
							this.setRender(true);
							this.setMensaje("Usuario o Password invalidos");
						}
					} else {
						response.sendRedirect("/webProject/faces/login.xhtml");
						this.setRender(true);
						this.setMensaje("Password no debe ser vacio");
					}
				} else {
					response.sendRedirect("/webProject/faces/login.xhtml");
					this.setRender(true);
					this.setMensaje("Usuario no debe ser vacio");
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	  
	public void refresh() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    ViewHandler viewHandler = application.getViewHandler();
	    UIViewRoot viewRoot = viewHandler.createView(context, context
	     .getViewRoot().getViewId());
	    context.setViewRoot(viewRoot);
	    context.renderResponse(); 
	 }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the render
	 */
	public boolean isRender() {
		return render;
	}

	/**
	 * @param render
	 *            the render to set
	 */
	public void setRender(boolean render) {
		this.render = render;
	}

}
