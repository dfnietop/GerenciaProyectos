
package com.muebles.seguridad;

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

	private String ususario;
	private String pass;
	private String url;
	private String bd;
	private static Connection conexion = null;
	private static RegistroInmueblesBean registro = new RegistroInmueblesBean();
	private Usuario id = new Usuario();
	ArrayList lista = new ArrayList();
	private String nombre;
	private String direccion;
	private String telefono;
	private String VentOArr;
	private String TipNeg;
	private String Comments;
	private String idusuario;

	public RegistroInmueblesBean() {
		// TODO Auto-generated constructor stub
	}

	public void registroInmuebles(ActionEvent evento) {
		if (evento.getComponent().getId().equals("guardar")) {
			Inmuebles Inm = new Inmuebles();
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
	/**
	public void consultain(){
		Inmuebles Inm = new Inmuebles();
		InmueblesDao InmD = new InmueblesDao();
		Conexion conexion = new Conexion();
		Inm.setINMNOM(this.nombre);
		Inm.setINMDIR(this.direccion);
		Inm.setINCCOMMENTS(this.Comments);
		Inm.setINMNEGOC(this.TipNeg);
		Inm.setINMTEL(this.telefono);
		Inm.setINMVENOARR(this.VentOArr);
		Inm.setIdusuario(this.idusuario);
		InmD.consultarInmueble(Inm, conexion);
	}
*/
	public void consultainmueble() {
		String a;
		String b;
		String c;
		String d;
		String f;

		try {
			// Properties propiedades = new Properties();
			// propiedades.load(new FileInputStream(
			// "/PersistenceResource.properties"));
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/pruebass";
			String usuarioDB = "root";
			String passwordDB = "12345";
			conexion = DriverManager.getConnection(servidor, usuarioDB,
					passwordDB);
			// this.bd = propiedades.getProperty("bd");
			// this.url = propiedades.getProperty("url");
			// this.pass = propiedades.getProperty("pass");
			// this.ususario = propiedades.getProperty("usuario");

			// Class.forName("com.mysql.jdbc.Driver");
			// conexion = DriverManager.getConnection("jdbc:mysql://" + url +
			// "/"
			// + bd, ususario, pass);

			Statement comando = conexion.createStatement();
			String sql = "SELECT id,nombre,direccion,telefono,estado FROM inmuebles WHERE id="
					+ id.getId();

			// System.out.println(n + " " + a);

			ResultSet resultado = comando.executeQuery(sql);
			while (resultado.next()) {
				a = resultado.getString("id");
				b = resultado.getString("nombre");
				c = resultado.getString("direccion");
				d = resultado.getString("telefono");
				f = resultado.getString("estado");

				lista.add(a);
				lista.add(b);
				lista.add(c);
				lista.add(d);
				lista.add(f);
			}
			resultado.close();
			comando.close();
			conexion.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

}
