package com.co.ceiba.restparqueadero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.rest.ParqueaderoRest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestparqueaderoApplicationTests {

	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	@Test
	public void contextLoads() {
		List<Vehiculo> listaVehiculos = vehiculoRepositorio.findAll();
		
	}

}
