package com.co.ceiba.restparqueadero.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.co.ceiba.restparqueadero.bean.ResponseConsulta;
import com.co.ceiba.restparqueadero.bean.ResponseSalidaVehiculo;
import com.co.ceiba.restparqueadero.bean.VehiculoMap;
import com.co.ceiba.restparqueadero.exception.VehiculoException;
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.util.Properties;
import com.co.ceiba.restparqueadero.util.ValidacionesIngreso;
import com.co.ceiba.restparqueadero.util.ValidacionesSalida;
import com.google.gson.Gson;

/**
 * Clase para las validaciones del Rest de Salida de Vehiculos
 * 
 * @author: Daniel.Mejia
 */
@Transactional
@Service
public class ParqueaderoServiceImp implements ParqueaderoService {

	private static final Logger logger = LoggerFactory.getLogger(ParqueaderoServiceImp.class);

	Properties properties;

	VehiculoRepositorio vehiculoRepositorio;

	@Autowired
	public ParqueaderoServiceImp(Properties properties, VehiculoRepositorio vehiculoRepositorio) {
		super();
		this.properties = properties;
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	/**
	 * Implementacion del Servicio de Ingreso de Vehiculos
	 * 
	 * @param vehiculoJson
	 *            String que contiene el request enforma de Json del vehiculo que
	 *            sera insertado.
	 */
	@Override
	public String ingresoVehiculo(String vehiculoJson) {
		Gson gson = new Gson();
		VehiculoMap vehiculo = gson.fromJson(vehiculoJson, VehiculoMap.class);
		ValidacionesIngreso validator = new ValidacionesIngreso();
		try {
			Vehiculo insertarVehiculo = validator.instanciarVehiculo(vehiculo);
			validator.valPlaca(vehiculo.getPlaca(), properties);
			validator.valRegla(vehiculo.getPlaca(), properties);
			int conteoAutomovil = vehiculoRepositorio.contarVehiculos(vehiculo.getTipoVehiculo());
			validator.valCapacidad(vehiculo.getTipoVehiculo(), conteoAutomovil, properties);
			vehiculoRepositorio.save(insertarVehiculo);
			return properties.msgExito;
		} catch (Exception e) {
			logger.error(properties.errorGenerico + e);
			return e.getMessage();
		}

	}

	/**
	 * Implementacion del Servicio Salida de Vehiculos
	 * 
	 * @param placa
	 *            String que contiene la placa del vehiculo que saldrá del
	 *            parqueadero vehiculo que sera insertado.
	 */
	@Override
	public ResponseSalidaVehiculo calcularValorSalida(String placa) {
		ValidacionesSalida validador = new ValidacionesSalida();
		ValidacionesIngreso validator = new ValidacionesIngreso();
		ResponseSalidaVehiculo respSalida = new ResponseSalidaVehiculo();

		int cobro = 0;
		try {
			validator.valPlaca(placa, properties);
			Vehiculo vehiculo = vehiculoRepositorio.buscarVehiculo(placa);
			if (null != vehiculo) {
				int horasTotales = validador.calculoHoras(vehiculo.getHoraIngreso().toString());
				cobro = validador.calculoPrecio(horasTotales, vehiculo, properties);
				Date hora = new Date();
				hora.getTime();
				vehiculo.setHoraSalida(hora);
				vehiculoRepositorio.save(vehiculo);
				respSalida.setValor(cobro);
				respSalida.setMensaje(properties.msgExito);
			} else {
				throw new VehiculoException(properties.noVehiculo);
			}
		} catch (Exception e) {
			logger.error("ERROR" + e);
			respSalida.setValor(0);
			respSalida.setMensaje(e.getMessage());
		}
		return respSalida;
	}

	/**
	 * Implementacion del Servicio Consultar todos los vehiculos
	 */
	@Override
	public ResponseConsulta consultarVehiculos() {
		ResponseConsulta respConsulta = new ResponseConsulta();
		try {
			List<Vehiculo> listaVeiculos = vehiculoRepositorio.buscarTodasVehiculo();
			respConsulta.setListVehiculos(listaVeiculos);
			respConsulta.setMensaje(properties.msgExito);
		} catch (Exception e) {
			logger.error(properties.errorGenerico + e);
			respConsulta.setMensaje(properties.errorGenerico);
		}
		return respConsulta;
	}

}
