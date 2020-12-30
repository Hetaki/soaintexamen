package com.jhuaman.soaint.examen.utils;

public enum EnumMoneda {

	SOLES("PEN", "Soles"),
	DOLARES("USD", "Dolares");

	private String codigo;
	private String descripcion;

	private EnumMoneda(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public static EnumMoneda getByCodigo(String codigo) {
	    for(EnumMoneda e : EnumMoneda.values()) {
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

