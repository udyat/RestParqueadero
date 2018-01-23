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

/**
 * Servicios Rest de gestion de parqueadero
 * @author: Daniel.Mejia
 */
@RestController
@RequestMapping("/api")
public class ParqueaderoRest {
	
	@Autowired
	private ParqueaderoService parqueaderoService;

	/**
     * Rest de Ingreso de Vehiculos
     * @param vehiculo String que contiene el request enforma de Json del
     * vehiculo que sera insertado.
     * @return String que contiene el mensaje de exito o error del ingreso 
     * del vehiculo
     */
	@CrossOrigin
	@PostMapping("/ingresarvehiculo")
	public String ingresarVehiculo(@Valid @RequestBody String vehiculo) {
		return parqueaderoService.ingresoVehiculo(vehiculo);
	}
	
	/**
     * Rest de Salida de Vehiculos
     * @param placa String que contiene la placa del vehiculo que saldra del parqueadero
     * @return ResponseSalidaVehiculo Objeto que contiene el mensaje del proceso
     * de salida del vehiculo y el valor a pagar
     */
	@CrossOrigin
	@PostMapping("/salidavehiculo")
	public ResponseSalidaVehiculo calcularPago(@Valid @RequestBody String placa) {
	    return parqueaderoService.calcularValorSalida(placa);
	    
	}
	
	/**
     * Rest de Consulta de Vehiculos
     * @return ResponseConsulta Objeto que contiene el mensaje del proceso
     * de consulta de vehiculos y la lista de vehiculos en el parqueadero
     */
	@CrossOrigin
	@GetMapping("/consultarvehiculos")
	public ResponseConsulta consultarvehiculos() {
	    return parqueaderoService.consultarVehiculos();
	    
	}
}
