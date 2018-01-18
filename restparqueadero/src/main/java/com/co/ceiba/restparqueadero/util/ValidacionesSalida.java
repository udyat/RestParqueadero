package com.co.ceiba.restparqueadero.util;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.co.ceiba.restparqueadero.model.Vehiculo;

public class ValidacionesSalida {
	
	public int calculoHoras(String fechaIngreso) {
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		DateTime dt = formatter.parseDateTime(fechaIngreso);
		DateTime dateTime = new DateTime();
		Period p = new Period(dt, dateTime);
		int totalH = p.getHours() + p.getDays()*24 + p.getWeeks()*7*24 + p.getYears()*365*24;
		if(p.getMinutes()> 0)totalH++;
		return totalH;
	}
	
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
