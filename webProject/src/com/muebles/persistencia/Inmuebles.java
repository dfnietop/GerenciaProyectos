package com.muebles.persistencia;

import java.util.ArrayList;

public class Inmuebles {

	private int id;
	private String INMNOM;
	private String INMTEL;
	private String INMDIR;
	private String INMVENOARR;
	private String INMNEGOC;
	private String INCCOMMENTS;
	private String idusuario;
	ArrayList<Inmuebles> lista = new ArrayList<Inmuebles>();
	

	public Inmuebles(int id, String b, String c, String d, String f) {
		this.id=id;
		this.INMNOM=b;
		this.INMDIR=c;
		this.INMTEL=d;
		this.INMNEGOC=f;	
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the iNMNOM
	 */
	public String getINMNOM() {
		return INMNOM;
	}

	/**
	 * @param iNMNOM
	 *            the iNMNOM to set
	 */
	public void setINMNOM(String iNMNOM) {
		INMNOM = iNMNOM;
	}

	/**
	 * @return the iNMTEL
	 */
	public String getINMTEL() {
		return INMTEL;
	}

	/**
	 * @param iNMTEL
	 *            the iNMTEL to set
	 */
	public void setINMTEL(String iNMTEL) {
		INMTEL = iNMTEL;
	}

	/**
	 * @return the iNMDIR
	 */
	public String getINMDIR() {
		return INMDIR;
	}

	/**
	 * @param iNMDIR
	 *            the iNMDIR to set
	 */
	public void setINMDIR(String iNMDIR) {
		INMDIR = iNMDIR;
	}

	/**
	 * @return the iNMVENOARR
	 */
	public String getINMVENOARR() {
		return INMVENOARR;
	}

	/**
	 * @param iNMVENOARR
	 *            the iNMVENOARR to set
	 */
	public void setINMVENOARR(String iNMVENOARR) {
		INMVENOARR = iNMVENOARR;
	}

	/**
	 * @return the iNMNEGOC
	 */
	public String getINMNEGOC() {
		return INMNEGOC;
	}

	/**
	 * @param iNMNEGOC
	 *            the iNMNEGOC to set
	 */
	public void setINMNEGOC(String iNMNEGOC) {
		INMNEGOC = iNMNEGOC;
	}

	/**
	 * @return the iNCCOMMENTS
	 */
	public String getINCCOMMENTS() {
		return INCCOMMENTS;
	}

	/**
	 * @param iNCCOMMENTS
	 *            the iNCCOMMENTS to set
	 */
	public void setINCCOMMENTS(String iNCCOMMENTS) {
		INCCOMMENTS = iNCCOMMENTS;
	}

	/**
	 * @return the idusuario
	 */
	public String getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario
	 *            the idusuario to set
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

}

