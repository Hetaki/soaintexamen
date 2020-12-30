package com.jhuaman.soaint.examen.utils;

public enum EnumEstadoPago {

	PAGADO("01", "Pagado"),
	DECLINADA("02", "Declinada"),
	FALLIDA("03", "Fallida"),
	ANULADA("04", "Anulada");

	private String codigo;
	private String descripcion;

	private EnumEstadoPago(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public static EnumEstadoPago getByCodigo(String codigo) {
	    for(EnumEstadoPago e : EnumEstadoPago.values()) {
	        if(e.codigo.equals(codigo)) return e;
	    }
	    return null;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	
}

