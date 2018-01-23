package com.co.ceiba.restparqueadero.util;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.co.ceiba.restparqueadero.model.Vehiculo;


/**
 * Clase para las validaciones del Rest de Salida de Vehiculos
 * @author: Daniel.Mejia
 */
public class ValidacionesSalida {
	
	/**
     * Método que calcula cuantas horas estubo el vehiculo en el parqueadero
     * @param fechaIngreso String de Fecha de ingreso del vehiculo al parqueadero
     */
	public int calculoHoras(String fechaIngreso) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		DateTime dt = formatter.parseDateTime(fechaIngreso);
		DateTime dateTime = new DateTime();
		Period p = new Period(dt, dateTime);
		int totalH = p.getHours() + p.getDays()*24 + p.getWeeks()*7*24 + p.getYears()*365*24;
		if(p.getMinutes()> 0)totalH++;
		return totalH;
	}
	
	/**
     * Método que calcula el valor a pagar de un vehiculo al salir del parqueadero
     * @param totalHoras Entero que indica el total de horas que permaneció un vehiculo
     * @param vehiculo Objeto que contiene la informacion del vehiculo
     * @param properties Instancia del las propiedades para las validaciones de calculo de ingreso
     */
	public int calculoPrecio(int totalHoras, Vehiculo vehiculo, Properties properties) {
		int cobro = 0;
		int modHoras = totalHoras % 24;
		int cobroInicial = (totalHoras / 24);

		if (vehiculo.getTiposVehiculo().getIdTipoVehiculo() == 1) {
			cobro = cobroInicial * properties.diaMoto;
			if (modHoras < 9) {
				cobro = cobro + modHoras * properties.horaMoto;
			} else {
				cobro = cobro + properties.diaMoto;
			}
			if (vehiculo.getCilindraje() > properties.cilindraje) {
				cobro = cobro + properties.adicional;
			}
		} else if (vehiculo.getTiposVehiculo().getIdTipoVehiculo() == 2) {
			cobro = cobroInicial * properties.diaCarro;
			if (modHoras < 9) {
				cobro = cobro + modHoras * properties.horaCarro;
			} else {
				cobro = cobro + properties.diaCarro;
			}
		}

		return cobro;
	}

}
