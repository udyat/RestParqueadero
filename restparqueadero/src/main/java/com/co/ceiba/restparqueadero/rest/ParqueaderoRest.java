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
import com.co.ceiba.restparqueadero.bean.VehiculoMap;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;
import com.google.gson.Gson;

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
	
//	@CrossOrigin
//	@PostMapping("/restTest")
//	public String restTest(@Valid @RequestBody String testTest) {
//		
//		System.out.println("asdasd" + testTest);
//		
//		
//		Gson gson = new Gson();
//		VehiculoMap vehiculo = gson.fromJson(testTest, VehiculoMap.class);
//		System.out.println("adad" + vehiculo.getValor1() + vehiculo.getValor2() + vehiculo.getValor3());
//	    return "exit";
//	}
	
	@GetMapping("/consultarvehiculos")
	public ResponseConsulta consultarvehiculos() {
	    return parqueaderoService.consultarVehiculos();
	    
	}
}
