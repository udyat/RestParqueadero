package com.co.ceiba.restparqueadero.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;

@RestController
@RequestMapping("/api")
public class ParqueaderoRest {
	
	@Autowired
	private ParqueaderoService parqueaderoService;

	@CrossOrigin
	
	@PostMapping("/ingresarvehiculo")
	public String ingresarVehiculo(@Valid @RequestBody String vehiculo) {
		return parqueaderoService.ingresoVehiculo(vehiculo);
	}
	@CrossOrigin
	@PostMapping("/salidavehiculo")
	public ResponseSalidaVehiculo calcularPago(@Valid @RequestBody String placa) {
	    return parqueaderoService.calcularValorSalida(placa);
	    
	}
	
	@GetMapping("/consultarvehiculos")
	public ResponseConsulta consultarvehiculos() {
	    return parqueaderoService.consultarVehiculos();
	    
	}
}
