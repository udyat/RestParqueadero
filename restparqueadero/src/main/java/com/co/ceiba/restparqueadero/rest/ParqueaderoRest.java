package com.co.ceiba.restparqueadero.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;

@RestController
@RequestMapping("/api")
public class ParqueaderoRest {
	
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	@PostMapping("/ingresarvehiculo")
	public Vehiculo ingresarVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
	    return vehiculoRepositorio.save(vehiculo);
	}
	
	@PostMapping("/calcularpago")
	public String calcularPago(@Valid @RequestBody String placa) {
		Vehiculo vehiculo = vehiculoRepositorio.findOne(placa);
		String valorPago = "";
	    return valorPago;
	    
	}
	
	@PostMapping("/sacarvehiculo")
	public String sacarvehiculo(@Valid @RequestBody String placa) {
		vehiculoRepositorio.delete(placa);
		String valorPago = "";
	    return valorPago;
	    
	}
	


}
