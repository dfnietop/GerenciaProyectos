package com.muebles.seguridad;

import java.awt.List;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import com.muebles.persistencia.Conexion;
import com.muebles.persistencia.Inmuebles;
import com.muebles.persistencia.InmueblesDao;
import com.muebles.persistencia.Usuario;

public class RegistroInmueblesBean {

	private Usuario id = new Usuario();


	private String nombre;
	private String direccion;
	private String telefono;
	private String VentOArr;
	private String TipNeg;
	private String Comments;
	private String idusuario;
		
ArrayList<Inmuebles> lista = new ArrayList<Inmuebles>();
Inmuebles Inm = new Inmuebles(0, Comments, Comments, Comments, Comments);
	public RegistroInmueblesBean() {
		// TODO Auto-generated constructor stub
	}

	public void registroInmuebles(ActionEvent evento) {
		if (evento.getComponent().getId().equals("guardar")) {
			Inmuebles Inm = new Inmuebles(0, Comments, Comments, Comments, Comments);
			InmueblesDao InmD = new InmueblesDao();
			Conexion conexion = new Conexion();
			Inm.setINMNOM(this.nombre);
			Inm.setINMDIR(this.direccion);
			Inm.setINMTEL(this.telefono);
			Inm.setINMVENOARR(this.VentOArr);
			Inm.setINMNEGOC(this.TipNeg);
			Inm.setINCCOMMENTS(this.Comments);
			//Inm.setIdusuario(this.idusuario);
			InmD.crearInmueble(Inm, conexion);
		}
		

	}
	
	public void consultain(ActionEvent evento){
		//if (evento.getComponent().getId().equals("guardar")) {
		InmueblesDao InmD = new InmueblesDao();
		Inmuebles Inm = new Inmuebles(0,nombre ,direccion ,telefono ,TipNeg);

		Conexion conexion = new Conexion();
	
		Inm.getId();
		Inm.getINMNOM();
		Inm.getINMDIR();
		Inm.getINMTEL();
		Inm.getINMNEGOC();
		InmD.consultarInmueble(conexion);
		
	//lista.add(arg0)
		//InmD.getLista();
		}
	//}
	
	public String getidusuario() {
		return idusuario;
	}

	public String setidusuario(String idusuario) {
		return idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVentOArr() {
		return VentOArr;
	}

	public void setVentOArr(String ventOArr) {
		VentOArr = ventOArr;
	}

	public String getTipNeg() {
		return TipNeg;
	}

	public void setTipNeg(String tipNeg) {
		TipNeg = tipNeg;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}
	public ArrayList<Inmuebles> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Inmuebles> lista) {
		
		this.lista = lista;
	}
}




