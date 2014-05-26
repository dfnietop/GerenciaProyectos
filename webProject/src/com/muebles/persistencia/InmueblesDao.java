package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.muebles.seguridad.RegistroInmueblesBean;



public class InmueblesDao {
	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}

	//Inmuebles registro=new Inmuebles();
	ArrayList<String> lista = new ArrayList<String>();
	Usuario usuario =new Usuario();
	public void crearInmueble(Inmuebles Inm, Conexion conexion) {
	
		try {
			
			
			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();
			String sql ="INSERT INTO  inmueble (nombre,direccion,telefono,estado,negocio,comentarios,id)"+" VALUES("+"'"+
			Inm.getINMNOM()+"',"
				+ "'"+Inm.getINMDIR()+"',"
							+ "'"+Inm.getINMTEL()+"',"
							+ "'"+Inm.getINMVENOARR()
							+"','"+Inm.getINMNEGOC()+"'"
							+",'"+Inm.getINCCOMMENTS()+"'"
							+","+usuario.getId()+");";
			
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
	
	public void consultarInmueble(Conexion conexion) {
		try {
			String a;
			String b;
			String c;
			String d;
			String f;
			

			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();
			//Statement comando = conexion.createStatement();
			String sql = "SELECT id,nombre,direccion,telefono,estado FROM inmueble WHERE id=1";
					//+ Inm.getId();
			ResultSet resultado = st.executeQuery(sql);
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
				System.out.println(a);
				System.out.println(b);
				
			
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




}

