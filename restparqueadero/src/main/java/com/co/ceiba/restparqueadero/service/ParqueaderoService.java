package com.co.ceiba.restparqueadero.service;

import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;

public interface ParqueaderoService {
	
	public String ingresoVehiculo(Vehiculo vehiculo);
	public ResponseSalidaVehiculo calcularValorSalida(String placa);
	public ResponseConsulta consultarVehiculos();

}
