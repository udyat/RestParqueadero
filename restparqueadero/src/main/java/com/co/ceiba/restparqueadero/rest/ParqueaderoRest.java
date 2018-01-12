package com.co.ceiba.restparqueadero.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.ceiba.restparqueadero.bean.ResponseIngreso;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;

@RestController
@RequestMapping("/api")
public class ParqueaderoRest {
	
	@Autowired
	private ParqueaderoService parqueaderoService;

	@PostMapping("/ingresarvehiculo")
	public ResponseIngreso ingresarVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
		return parqueaderoService.ingresoVehiculo(vehiculo);
	}
	@PostMapping("/calcularpago")
	public String calcularPago(@Valid @RequestBody String placa) {
	    return parqueaderoService.calcularValorSalida(placa);
	    
	}
	@PostMapping("/sacarvehiculo")
	public List<Vehiculo> consultarvehiculos(@Valid @RequestBody String placa) {
	    return parqueaderoService.consultarVehiculos();
	    
	}
}
