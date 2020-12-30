package com.jhuaman.soaint.examen.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class SucursalVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long idSucursal;
	private String nombre;
	private String direccion;
	private String fecRegistro;

	private long idBanco;
	private BancoVO banco;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the fecRegistro
	 */
	public String getFecRegistro() {
		return fecRegistro;
	}

	/**
	 * @param fecRegistro
	 *            the fecRegistro to set
	 */
	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	/**
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	/**
	 * @return the banco
	 */
	public BancoVO getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(BancoVO banco) {
		this.banco = banco;
	}

	/**
	 * @return the idBanco
	 */
	public long getIdBanco() {
		return idBanco;
	}

	/**
	 * @param idBanco the idBanco to set
	 */
	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

	
	
}
