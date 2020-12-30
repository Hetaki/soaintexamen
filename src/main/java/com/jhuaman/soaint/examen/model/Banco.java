package com.jhuaman.soaint.examen.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Banco")
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBanco;

	private String nombre;
	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecRegistro;

	/**
	 * @return the idBanco
	 */
	public long getIdBanco() {
		return idBanco;
	}

	/**
	 * @param idBanco
	 *            the idBanco to set
	 */
	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

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
	public Date getFecRegistro() {
		return fecRegistro;
	}

	/**
	 * @param fecRegistro
	 *            the fecRegistro to set
	 */
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

}
