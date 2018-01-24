package com.co.ceiba.restparqueadero;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.bean.VehiculoMap;
import com.co.ceiba.restparqueadero.exception.VehiculoException;
import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.rest.ParqueaderoRest;
import com.co.ceiba.restparqueadero.service.ParqueaderoService;
import com.co.ceiba.restparqueadero.service.ParqueaderoServiceImp;
import com.co.ceiba.restparqueadero.util.Properties;
import com.co.ceiba.restparqueadero.util.ValidacionesIngreso;
import com.co.ceiba.restparqueadero.util.ValidacionesSalida;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestparqueaderoApplicationTests {

	@InjectMocks
	ParqueaderoServiceImp parqueaderoServicemock;
	
	@Mock
	Properties propertiesmock;
	
	@Mock
	 VehiculoRepositorio vehiculoRepositoriomock;
	
	@Autowired
	 Properties properties;
	
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	
	

	@Autowired
	ParqueaderoService parqueaderoService;
	
	@Test
	public void ingresarVehiculoMoto() {
		String request = "{'placa': 'DEY566','propietario': 'German','tipoVehiculo': 1,'cilindraje': 500}";
		parqueaderoService.ingresoVehiculo(request);
		Vehiculo vehiculo = vehiculoRepositorio.buscarVehiculo("DEY566");
		vehiculoRepositorio.delete(vehiculo);
	}
	@Test
	public void testException() {
		String request = "{'placa': 'YYYYYY','propietario': 'German','tipoVehiculo': 1,'cilindraje': 500}";
		parqueaderoService.ingresoVehiculo(request);
	}
	
	@Test
	public void ingresarVehiculoCarro() {
		String request = "{'placa': 'DEY510','propietario': 'German','tipoVehiculo': 2}";
		parqueaderoService.ingresoVehiculo(request);
		Vehiculo vehiculo = vehiculoRepositorio.buscarVehiculo("DEY510");
		vehiculoRepositorio.delete(vehiculo);
	}
	@Test
	public void horas() {
		String fechaIngreso = "2018-01-22 13:00:45.000";

		ValidacionesSalida valSalida = new ValidacionesSalida();
		int horas = valSalida.calculoHoras(String.valueOf(fechaIngreso));
		System.out.println("asd" + horas);
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
	public void testCobroDiesHorasMotoCilindraje() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		vehiculo.setCilindraje(800);
		assertEquals(6000,valSalida.calculoPrecio(10, vehiculo, properties));

	}
	
	
	@Test
	public void testCobroDiesHorasMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		vehiculo.setCilindraje(500);
		assertEquals(4000,valSalida.calculoPrecio(10, vehiculo, properties));

	}
	
	
	@Test
	public void testCobroVentCuatroHorasMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		vehiculo.setCilindraje(500);
		assertEquals(4000,valSalida.calculoPrecio(24, vehiculo, properties));
	}
	
	@Test
	public void testCobroDosDiaMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		vehiculo.setCilindraje(500);
		assertEquals(8000,valSalida.calculoPrecio(40, vehiculo, properties));
	}
	
	@Test
	public void testCobroUnDiaMoto() {
		ValidacionesSalida valSalida = new ValidacionesSalida();
		Vehiculo vehiculo = new Vehiculo();
		TiposVehiculo tipov = new TiposVehiculo();
		tipov.setIdTipoVehiculo(1);
		vehiculo.setTiposVehiculo(tipov);
		vehiculo.setCilindraje(500);
		assertEquals(5500,valSalida.calculoPrecio(27, vehiculo, properties));
	}
	
	@Test
	public void instanciaMap() {
		VehiculoMap vehiculoMap = new VehiculoMap();
		vehiculoMap.setCilindraje(0);
		vehiculoMap.getCilindraje();
		vehiculoMap.setPlaca("");
		vehiculoMap.getPlaca();
		vehiculoMap.setPropietario("");
		vehiculoMap.getPropietario();
		vehiculoMap.setTipoVehiculo(1);
		vehiculoMap.getTipoVehiculo();
		TiposVehiculo tipo = new TiposVehiculo();
		tipo.setDescripcion("hola");
		tipo.setIdTipoVehiculo(1);
	}
	
	@Test
	public void instanciaRest() {
		ParqueaderoRest rest = new ParqueaderoRest();
		assertNotNull(rest);
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
	public void testSalirMoto() {
		
		String request = "{'placa': 'DEY565','propietario': 'German','tipoVehiculo': 1,'cilindraje': 500}";
		parqueaderoService.ingresoVehiculo(request);
		ResponseSalidaVehiculo salidaVehiculo = parqueaderoService.calcularValorSalida("DEY565");
		assertNotNull(salidaVehiculo.getValor());

		
	}
	@Test
	public void testConsultarCarro() {
		ResponseConsulta response = parqueaderoService.consultarVehiculos();
		assertNotNull(response.getListVehiculos());
	}
	@Test
	public void testConsultarCarroMsj() {
		ResponseConsulta response = parqueaderoService.consultarVehiculos();
		assertNotNull(response.getMensaje());
	}
	
	@Test
	public void testIDNuev() {
		assertNotNull(vehiculoRepositorio.findOne(1));
		
	}
	
	@Test
	public void testMockInsertarVehiculos() {
		
		//arrange
		VehiculoRepositorio vehiculoRepositorioMock =  Mockito.mock(VehiculoRepositorio.class);
		String request = "{'placa': 'DEY555','propietario': 'German','tipoVehiculo': 1,'cilindraje': 500}";
		Vehiculo vehiculo = new Vehiculo();		
		Mockito.when(vehiculoRepositorioMock.save(Mockito.any(Vehiculo.class))).thenReturn(vehiculo);		
		ParqueaderoService parqueaderoService = new ParqueaderoServiceImp(properties, vehiculoRepositorioMock);
		
		//act
		String resultadoIngresoVehiculo = parqueaderoService.ingresoVehiculo(request);
		
		//assert
		assertEquals("Transacción Exitosa.", resultadoIngresoVehiculo);

		
	}
	


}
