package com.co.ceiba.restparqueadero.bean;

import java.util.List;

import com.co.ceiba.restparqueadero.model.Vehiculo;

/**
 * Clase de Mapeo del response del Rest de Consulta de vehiculo
 * @author: Daniel.Mejia
 */
public class ResponseConsulta {
	
	private List<Vehiculo> listVehiculos;
	private String mensaje;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<Vehiculo> getListVehiculos() {
		return listVehiculos;
	}
	public void setListVehiculos(List<Vehiculo> listVehiculos) {
		this.listVehiculos = listVehiculos;
	}

}
