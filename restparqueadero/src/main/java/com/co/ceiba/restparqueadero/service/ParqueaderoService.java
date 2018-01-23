package com.co.ceiba.restparqueadero.service;

import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;

/**
 * Interface de la capa de servicio del Parqueadero
 * @author: Daniel.Mejia
 */
public interface ParqueaderoService {
	
	public String ingresoVehiculo(String vehiculo);
	
	public ResponseSalidaVehiculo calcularValorSalida(String placa);
	
	public ResponseConsulta consultarVehiculos();

}
