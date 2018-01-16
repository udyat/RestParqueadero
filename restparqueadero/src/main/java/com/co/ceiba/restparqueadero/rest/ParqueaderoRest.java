package com.co.ceiba.restparqueadero.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;

@RestController
@RequestMapping("/api")
public class ParqueaderoRest {
	
	@Autowired
	private ParqueaderoService parqueaderoService;

	@PostMapping("/ingresarvehiculo")
	public String ingresarVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
		return parqueaderoService.ingresoVehiculo(vehiculo);
	}
	@PostMapping("/calcularpago")
	public ResponseSalidaVehiculo calcularPago(@Valid @RequestBody String placa) {
	    return parqueaderoService.calcularValorSalida(placa);
	    
	}
	@PostMapping("/sacarvehiculo")
	public ResponseConsulta consultarvehiculos(@Valid @RequestBody String placa) {
	    return parqueaderoService.consultarVehiculos();
	    
	}
}
