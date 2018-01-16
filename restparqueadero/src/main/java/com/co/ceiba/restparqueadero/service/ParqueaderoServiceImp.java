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
import com.co.ceiba.restparqueadero.model.Vehiculo;
import com.co.ceiba.restparqueadero.repository.VehiculoRepositorio;
import com.co.ceiba.restparqueadero.util.Properties;
import com.co.ceiba.restparqueadero.util.ValidacionesIngreso;
import com.co.ceiba.restparqueadero.util.ValidacionesSalida;

@Transactional
@Service
public class ParqueaderoServiceImp implements ParqueaderoService {

	private static final Logger logger = LoggerFactory.getLogger(ParqueaderoServiceImp.class); 
	
	@Autowired
	 Properties properties;
	@Autowired
	 VehiculoRepositorio vehiculoRepositorio;
	
	
	@Override
	public String ingresoVehiculo(Vehiculo vehiculo) {
		String response = "";
		
		ValidacionesIngreso validator = new ValidacionesIngreso();
		try {
			if(validator.valPlaca(vehiculo.getPlaca())) {
				if(validator.valRegla(vehiculo.getPlaca(), properties.regla)) {
						int conteoAutomovil = vehiculoRepositorio.contarVehiculos(vehiculo.getTiposVehiculo().getIdTipoVehiculo());
						if(validator.valCapacidad(vehiculo.getTiposVehiculo().getIdTipoVehiculo(),conteoAutomovil,properties)) {
							vehiculoRepositorio.save(vehiculo);
							response = properties.msgExito;
						}else {
							response = properties.parqueaderoLLeno;
						}
				}else {
					response = properties.msgDiaHabil;
				}
			}else {
				response = properties.errorPlaca;
			}
			return response;
		} catch (Exception e) {
			logger.error(properties.errorGenerico + e);
			return properties.errorGenerico;
		}
		
	}

	@Override
	public ResponseSalidaVehiculo calcularValorSalida(String placa) {
		ValidacionesSalida validador = new ValidacionesSalida();
		ResponseSalidaVehiculo respSalida = new ResponseSalidaVehiculo();
		int cobro = 0;
		try {
			Vehiculo vehiculo = vehiculoRepositorio.findOne(placa);
			int horasTotales = validador.calculoHoras(vehiculo.getHoraIngreso().toString());
			cobro = validador.calculoPrecio(horasTotales, vehiculo, properties);
			Date hora = new Date();
			hora.getTime();
			vehiculo.setHoraSalida(hora);
			vehiculoRepositorio.save(vehiculo);
			respSalida.setValor(cobro);
			respSalida.setMensaje(properties.msgExito);
		} catch (Exception e) {
			logger.error(properties.errorGenerico + e);
			respSalida.setValor(0);
			respSalida.setMensaje(properties.errorGenerico);
		}
		return respSalida;
	}

	@Override
	public ResponseConsulta consultarVehiculos() {
		ResponseConsulta respConsulta = new ResponseConsulta();
		try {
			List<Vehiculo> listaVeiculos = vehiculoRepositorio.findAll();
			respConsulta.setListVehiculos(listaVeiculos);
			respConsulta.setMensaje(properties.msgExito);
		} catch (Exception e) {
			logger.error(properties.errorGenerico + e);
			respConsulta.setMensaje(properties.errorGenerico);
		}
		return respConsulta;
	}

}
