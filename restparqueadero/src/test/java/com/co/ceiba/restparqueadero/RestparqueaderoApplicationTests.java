package com.co.ceiba.restparqueadero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.properties.Properties;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestparqueaderoApplicationTests {

	
	@Autowired
	 Properties properties;
	
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	@Autowired
	ParqueaderoService parqueaderoService;
	
//	@Test
//	public void contextLoads() {
//		List<Vehiculo> listaVehiculos = vehiculoRepositorio.findAll();
//		
//	}
	@Test
	public void contextLoads2() {
		TiposVehiculo tipoV = new TiposVehiculo();
		tipoV.setIdTipoVehiculo(2);
		int listaVehiculos = vehiculoRepositorio.countByTiposVehiculo(tipoV);
		
		 Pattern p = Pattern.compile("^[A-Z]{3}\\d{3}");
		 Matcher m = p.matcher("ASN575");
		 boolean b = m.matches();
		
		System.out.println(properties.msgMaxCarros + parqueaderoService.calcularValorSalida(""));
		
	}

}
