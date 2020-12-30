package com.jhuaman.soaint.examen.vo;

public class RespuestaVO<T> {

	private boolean exito;
	private String mensaje;
	private T data;

	public RespuestaVO() {
	}

	public RespuestaVO(boolean exito, String mensaje) {
		this.exito = exito;
		this.mensaje = mensaje;
	}
	public RespuestaVO(T data) {
		this.exito = true;
		this.mensaje = "";
		this.data = data;
	}

	/**
	 * @return the exito
	 */
	public boolean isExito() {
		return exito;
	}

	/**
	 * @param exito
	 *            the exito to set
	 */
	public void setExito(boolean exito) {
		this.exito = exito;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}
