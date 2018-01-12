package com.co.ceiba.restparqueadero.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.ceiba.restparqueadero.bean.ResponseIngreso;
import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.properties.Properties;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;

@Transactional
@Service
public class ParqueaderoServiceImp implements ParqueaderoService {

	@Autowired
	 Properties properties;
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	
	@Override
	public ResponseIngreso ingresoVehiculo(Vehiculo vehiculo) {
		ResponseIngreso response = new ResponseIngreso();
		TiposVehiculo tipoVehiculo = vehiculo.getTiposVehiculo();
		try {
			int conteoAutomovil = vehiculoRepositorio.countByTiposVehiculo(vehiculo.getTiposVehiculo());
			 if(tipoVehiculo.getIdTipoVehiculo() == 1) {		
				if (conteoAutomovil<properties.maxMoto) {
					vehiculoRepositorio.save(vehiculo);
				} else {
					response.setCodigo(properties.error);
					response.setMensaje(properties.msgMaxMotos);
				}
			}else if (tipoVehiculo.getIdTipoVehiculo() == 2) {
				if (conteoAutomovil<properties.maxCarro) {
					vehiculoRepositorio.save(vehiculo);
				} else {
					response.setCodigo(properties.error);
					response.setMensaje(properties.msgMaxCarros);
				}
			}
			
			
			
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(vehiculo.getHoraIngreso()); 
			//if(calendar.get(Calendar.DAY_OF_WEEK) == )
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	@Override
	public String calcularValorSalida(String placa) {
		return "hi";
	}

	@Override
	public List<Vehiculo> consultarVehiculos() {
		List<Vehiculo> hola = new ArrayList<>();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("ASD123");
		hola.add(vehiculo);
		return hola;
	}

}
