package com.jhuaman.soaint.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SucursalOrdenPago")
public class SucursalOrdenPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSucursalOrden;
	private long idOrdenPago;
	private long idSucursal;

	/**
	 * @return the idSucursalOrden
	 */
	public long getIdSucursalOrden() {
		return idSucursalOrden;
	}

	/**
	 * @param idSucursalOrden
	 *            the idSucursalOrden to set
	 */
	public void setIdSucursalOrden(long idSucursalOrden) {
		this.idSucursalOrden = idSucursalOrden;
	}

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
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal
	 *            the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

}
