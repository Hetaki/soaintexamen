package com.jhuaman.soaint.examen.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrdenPago")
public class OrdenPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrdenPago;
	private BigDecimal monto;
	private String moneda;
	private String codEstado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecPago;

	/**
	 * @return the idOrdenPago
	 */
	public long getIdOrdenPago() {
		return idOrdenPago;
	}

	/**
	 * @param idOrdenPago
	 *            the idOrdenPago to set
	 */
	public void setIdOrdenPago(long idOrdenPago) {
		this.idOrdenPago = idOrdenPago;
	}

	/**
	 * @return the monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}

	/**
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda
	 *            the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the fecPago
	 */
	public Date getFecPago() {
		return fecPago;
	}

	/**
	 * @param fecPago
	 *            the fecPago to set
	 */
	public void setFecPago(Date fecPago) {
		this.fecPago = fecPago;
	}

	/**
	 * @return the codEstado
	 */
	public String getCodEstado() {
		return codEstado;
	}

	/**
	 * @param codEstado the codEstado to set
	 */
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

}
