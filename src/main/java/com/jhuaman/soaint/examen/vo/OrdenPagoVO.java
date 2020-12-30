package com.jhuaman.soaint.examen.vo;

import java.math.BigDecimal;
import java.util.List;

public class OrdenPagoVO {

	private long idOrdenPago;
	private BigDecimal monto;
	private String codMoneda;
	private String desMoneda;
	private String fecPago;
	private String codEstado;
	private String desEstado;

	private List<SucursalVO> sucursales;

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
	 * @return the fecPago
	 */
	public String getFecPago() {
		return fecPago;
	}

	/**
	 * @param fecPago
	 *            the fecPago to set
	 */
	public void setFecPago(String fecPago) {
		this.fecPago = fecPago;
	}

	/**
	 * @return the sucursales
	 */
	public List<SucursalVO> getSucursales() {
		return sucursales;
	}

	/**
	 * @param sucursales
	 *            the sucursales to set
	 */
	public void setSucursales(List<SucursalVO> sucursales) {
		this.sucursales = sucursales;
	}

	/**
	 * @return the codMoneda
	 */
	public String getCodMoneda() {
		return codMoneda;
	}

	/**
	 * @param codMoneda
	 *            the codMoneda to set
	 */
	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}

	/**
	 * @return the desMoneda
	 */
	public String getDesMoneda() {
		return desMoneda;
	}

	/**
	 * @param desMoneda
	 *            the desMoneda to set
	 */
	public void setDesMoneda(String desMoneda) {
		this.desMoneda = desMoneda;
	}

	/**
	 * @return the codEstado
	 */
	public String getCodEstado() {
		return codEstado;
	}

	/**
	 * @param codEstado
	 *            the codEstado to set
	 */
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	/**
	 * @return the desEstado
	 */
	public String getDesEstado() {
		return desEstado;
	}

	/**
	 * @param desEstado
	 *            the desEstado to set
	 */
	public void setDesEstado(String desEstado) {
		this.desEstado = desEstado;
	}

}
