package com.co.ceiba.restparqueadero;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.exception.VehiculoException;
import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;
import com.co.ceiba.restparqueadero.util.Properties;
import com.co.ceiba.restparqueadero.util.ValidacionesIngreso;
import com.co.ceiba.restparqueadero.util.ValidacionesSalida;

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
	public void ingresarVehiculoMoto() {
		Vehiculo vehiculo = new Vehiculo();
		Date hora = new Date();
		hora.getTime();
		vehiculo.setHoraIngreso(hora);
		vehiculo.setPlaca("FAA111");
		vehiculo.setPropietario("Nombre");
		TiposVehiculo tipo = new TiposVehiculo();
		tipo.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipo);
		vehiculo.setCilindraje(500);
		//String mensaje = parqueaderoService.ingresoVehiculo(vehiculo);
		//System.out.println(mensaje);
		//vehiculoRepositorio.delete(vehiculo.getPlaca());
	}
	
	@Test
	public void ingresarVehiculoCarro() {
		Vehiculo vehiculo = new Vehiculo();
		Date hora = new Date();
		hora.getTime();
		vehiculo.setHoraIngreso(hora);
		vehiculo.setPlaca("ROS500");
		vehiculo.setPropietario("Nombre");
		TiposVehiculo tipo = new TiposVehiculo();
		tipo.setIdTipoVehiculo(2);
		vehiculo.setTiposVehiculo(tipo);
		//String mensaje = parqueaderoService.ingresoVehiculo(vehiculo);
		//System.out.println(mensaje);
		//vehiculoRepositorio.delete(vehiculo.getPlaca());
	}
	@Test
	public void horas() {
		String fechaIngreso = "2018-01-15 06:30:45";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime dt = formatter.parseDateTime(fechaIngreso);
		DateTime dateTime = new DateTime();
		Period p = new Period(dt, dateTime);
		int horasToT = p.getHours() + p.getDays()*24 + p.getWeeks()*7*24 + p.getYears()*365*24;
		System.out.println(horasToT);
	}
	
	@Test
	public void testCobroDiesHorasCarro() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(2);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(8000,valSalida.calculoPrecio(10, vehiculo, properties));

	}
	
	
	@Test
	public void testCobroVentCuatroHorasCarro() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(2);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(8000,valSalida.calculoPrecio(24, vehiculo, properties));
	}
	
	@Test
	public void testCobroDosDiaCarro() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(2);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(16000,valSalida.calculoPrecio(40, vehiculo, properties));
	}
	
	@Test
	public void testCobroUnDiaCarro() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(2);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(11000,valSalida.calculoPrecio(27, vehiculo, properties));
	}
	@Test
	public void testCobroDiesHorasMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(8000,valSalida.calculoPrecio(10, vehiculo, properties));

	}
	
	
	@Test
	public void testCobroVentCuatroHorasMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(8000,valSalida.calculoPrecio(24, vehiculo, properties));
	}
	
	@Test
	public void testCobroDosDiaMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(16000,valSalida.calculoPrecio(40, vehiculo, properties));
	}
	
	@Test
	public void testCobroUnDiaMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		assertEquals(11000,valSalida.calculoPrecio(27, vehiculo, properties));
	}
	
	
	@Test
	public void testRegla()  {
		ValidacionesIngreso validacionesIngreso = new ValidacionesIngreso();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		
		try {
			assertEquals(true,validacionesIngreso.valRegla("AGH840",properties));
		} catch (VehiculoException e) {
			System.out.println("ERROR" + e);
		}
	}
	
	@Test
	public void testConsultar()  {
		ResponseConsulta RespConsultar =  parqueaderoService.consultarVehiculos();
		assertNotNull(RespConsultar);
	}
	
	
	
	
	
	@Test
	public void testSalirCarro() {
		String placa = "YKZ224";
		ResponseSalidaVehiculo hola = parqueaderoService.calcularValorSalida(placa);
		
	}
	
	@Test
	public void testIDNuev() {
		
		System.out.println("O LA LA LA"  + vehiculoRepositorio.findOne(1));
		
	}


}
