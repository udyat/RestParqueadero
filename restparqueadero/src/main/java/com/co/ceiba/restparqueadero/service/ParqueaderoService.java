package com.co.ceiba.restparqueadero.service;

import java.util.List;

import com.co.ceiba.restparqueadero.bean.ResponseIngreso;
import com.co.ceiba.restparqueadero.model.Vehiculo;

public interface ParqueaderoService {
	
	public ResponseIngreso ingresoVehiculo(Vehiculo other);
	public String calcularValorSalida(String placa);
	public List<Vehiculo> consultarVehiculos();

}
