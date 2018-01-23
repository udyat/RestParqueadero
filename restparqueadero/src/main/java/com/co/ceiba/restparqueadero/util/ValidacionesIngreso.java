package com.co.ceiba.restparqueadero.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.co.ceiba.restparqueadero.bean.VehiculoMap;
import com.co.ceiba.restparqueadero.exception.VehiculoException;
import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;

/**
 * Clase para las validaciones del Rest de Ingreso de Vehiculos
 * @author: Daniel.Mejia
 */
public class ValidacionesIngreso {
	
	/**
     * Método que valida que la placa sea tres letras en mayusculas y tres numeros
     * @param placa String que indica la placa que será validada
     * @param properties Instancia del las propiedades para las validaciones de placa
     */
	public boolean valPlaca(String placa, Properties properties) throws VehiculoException {
		Pattern pattern = Pattern.compile("^[A-Z]{3}\\d{3}");
		Matcher match = pattern.matcher(placa);
		if(!match.matches())throw new VehiculoException(properties.errorPlaca);
		return true;
	}
	
	/**
     * Método que valida la regla del negocio de ingreso de vehiculos que comienzan con A
     * @param placa String que indica la placa del vehiculo
     * @param properties Instancia del las propiedades para las validaciones de calculo de ingreso
     */
	public boolean valRegla(String placa,Properties properties) throws VehiculoException {
		if (String.valueOf(placa.charAt(0)).equalsIgnoreCase(properties.regla)) {
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(now); 
	        int day = calendar.get(Calendar.DAY_OF_WEEK);
	        if(!(day == 1 || day == 2)) throw new VehiculoException(properties.msgDiaHabil);
	        return true;
		} else {
			return true;
		}
	}
	
	/**
     * Método que instancia un objeto tipo vehiculo
     * @param vehiculo Objeto tipo VehiculoMap que contiene la información del vehiculo a ser mapeado.
     */
	public Vehiculo instanciarVehiculo(VehiculoMap vehiculo) {
		Vehiculo objVehiculo = new Vehiculo();
		TiposVehiculo objTipoVehiculo = new TiposVehiculo();
		objTipoVehiculo.setIdTipoVehiculo(vehiculo.getTipoVehiculo());
		objVehiculo.setCilindraje(vehiculo.getCilindraje());
		Date hora = new Date();
		hora.getTime();
		objVehiculo.setHoraIngreso(hora);
		objVehiculo.setPlaca(vehiculo.getPlaca());
		objVehiculo.setPropietario(vehiculo.getPropietario());
		objVehiculo.setTiposVehiculo(objTipoVehiculo);
		return objVehiculo;
	}
	
	/**
     * Método que valida la capacidad actual del parqueadero
     * @param tipoVehiculo Entero que indica si el vehiculo es carro(2) o moto(1)
     * @param conteoAutomovil Entero que contiene el numero de vehiculos que hay actualmente en el parqueadero
     * segun su tipo.
     * @param properties Instancia del las propiedades para las validaciones de capacidad
     */
	public boolean valCapacidad(int tipoVehiculo, int conteoAutomovil, Properties properties) throws VehiculoException {
		if (!((tipoVehiculo == 1 && conteoAutomovil < properties.maxMoto)
				|| (tipoVehiculo == 2 && conteoAutomovil < properties.maxCarro)))
			throw new VehiculoException(properties.parqueaderoLLeno);
		return true;
		
	}
	
}