package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.SessionEvent;

import com.muebles.seguridad.LoginBean;
import com.muebles.seguridad.RegistroBean;
import com.muebles.seguridad.RegistroInmueblesBean;



public class InmueblesDao {
	

	//Inmuebles registro=new Inmuebles();
	ArrayList<Inmuebles> lista = new ArrayList<Inmuebles>();
	Usuario usuario =new Usuario();
	LoginBean idn=new LoginBean();
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
							//+",1);";
							+","+idn.getId()+");";
			
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
	
	public ArrayList<Inmuebles> consultarInmueble(int id) {
		Conexion conexion = new Conexion();
		try {
			int a;
			String b;
			String c;
			String d;
			String f;
		

			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();
			//Statement comando = conexion.createStatement();
			String sql = "SELECT idin,nombre,direccion,telefono,negocio FROM inmueble WHERE id="+id+";";
					
			//+ Inm.getId();
			//"+usuario.getId()+"
			ResultSet resultado = st.executeQuery(sql);
			while (resultado.next()) {
				
				a = resultado.getInt("idin");
				b = resultado.getString("nombre");
				c = resultado.getString("direccion");
				d = resultado.getString("telefono");
				f = resultado.getString("negocio");

				//lista.add(a);
				//lista.add(b);
				//lista.add(c);
				//ista.add(d);
				//lista.add(f);
			            //Objeto del tipo Usuario
			          
				Inmuebles e = new Inmuebles(a,b,c,d,f);
			            lista.add(e);
			            
			            	for(int i = 0; i < lista.size(); i++) {
			                   // System.out.println(lista.get(i).getId());
			                   // System.out.println(lista.get(i).getINMNOM());
			                    //System.out.println(lista.get(i).getINMDIR());
			                    //System.out.println(lista.get(i).getINMTEL());
			                    //System.out.println(lista.get(i).getINMNEGOC());
			                    
			                }
			            
			    
			 
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
		return lista;   
	}
	




}
