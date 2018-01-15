package com.co.ceiba.restparqueadero;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;
import com.co.ceiba.restparqueadero.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestparqueaderoApplicationTests {

	
	@Autowired
	 Properties properties;
	
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	@Autowired
	ParqueaderoService parqueaderoService;
	
	@Test
	public void ingresarVehiculo() {
		Vehiculo vehiculo = new Vehiculo();
		Date hora = new Date();
		hora.getTime();
		vehiculo.setHoraIngreso(hora);
		vehiculo.setPlaca("AAA111");
		vehiculo.setPropietario("Nombre");
		TiposVehiculo tipo = new TiposVehiculo();
		tipo.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipo);
		parqueaderoService.ingresoVehiculo(vehiculo);
		vehiculoRepositorio.delete(vehiculo.getPlaca());
	}


}
