package com.muebles.persistencia;

import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.muebles.seguridad.RegistroInmueblesBean;



public class InmueblesDao {
	//Inmuebles registro=new Inmuebles();
	ArrayList lista = new ArrayList();
	RegistroInmueblesBean nuevo =new RegistroInmueblesBean();
	public void crearInmueble(Inmuebles Inm, Conexion conexion) {
		///Conexion conexion1 = new Conexion();
		try {
			
			System.out.println(Inm.getINMNOM());
			System.out.println(Inm.getINMDIR());
			System.out.println(nuevo.getNombre());
			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();
			//String sql="INSERT INTO  inmueble (nombre,direccion,telefono,estado,negocio,id) "
				//	+ "VALUES('hola','hola','hola','hola','hola',1);"; 
			String sql ="INSERT INTO  inmueble (nombre,direccion,telefono,estado,negocio,comentarios,id)"+" VALUES("+"'"+
			Inm.getINMNOM()+"',"
				+ "'"+Inm.getINMDIR()+"',"
							+ "'"+Inm.getINMTEL()+"',"
							+ "'"+Inm.getINMVENOARR()
							+"','"+Inm.getINMNEGOC()+"'"
							+",'"+Inm.getINCCOMMENTS()+"'"
							+",1);";
			//PreparedStatement pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			st.executeUpdate(sql);
		
			//ResultSet resultado = comando.executeQuery(sql);
//System.out.println(pstmt);
		//INSERT INTO  inmueble (nombre,direccion,telefono,estado,negocio,id) 
/// VALUES('hola','hola','hola','hola','hola',1);
			// TODO: REALIZAR LA INSERCION EN LA BASE DE DATOS, ES DECIR USTED
			// DEBE PONER LA ESTRUCTURA DE INSERCION DE MYSQL QUE NOS BRINDA
			// JAVA, COMO LO HACE BUSQUE EN INTERNET COMO CREAR UN METODO DE
			// INSERCION EN MYSQL IMPORTANTE NO SE LE VA A PASAR LA CONEXION

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
	/**
	public void consultarInmueble(Inmuebles Inm, Conexion conexion) {
		try {
			String a;
			String b;
			String c;
			String d;
			String f;
			
			conexion.getInstance().crearConexion();
			//Statement comando = conexion.createStatement();
			String sql = "SELECT id,nombre,direccion,telefono,estado FROM inmuebles WHERE id="
					+ Inm.getId();
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
			// TODO: REALIZAR LA INSERCION EN LA BASE DE DATOS, ES DECIR USTED
			// DEBE PONER LA ESTRUCTURA DE INSERCION DE MYSQL QUE NOS BRINDA
			// JAVA, COMO LO HACE BUSQUE EN INTERNET COMO CREAR UN METODO DE
			// INSERCION EN MYSQL IMPORTANTE NO SE LE VA A PASAR LA CONEXION

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
*/	


}
