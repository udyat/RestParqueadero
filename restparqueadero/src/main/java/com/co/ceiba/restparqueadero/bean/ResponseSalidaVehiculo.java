package com.co.ceiba.restparqueadero.bean;

/**
 * Clase de Mapeo del response del Rest de Salida de vehiculo
 * @author: Daniel.Mejia
 */
public class ResponseSalidaVehiculo {
	
	private int valor;
	private String mensaje;
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
