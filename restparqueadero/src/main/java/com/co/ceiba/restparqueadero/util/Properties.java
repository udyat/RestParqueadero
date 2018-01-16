package com.co.ceiba.restparqueadero.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	@Value("${parqueadero.mensaje.parqueaderolleno}")
	public String parqueaderoLLeno;	
	
	@Value("${parqueadero.mensaje.error.generico}")
	public String errorGenerico;
	
	@Value("${parqueadero.mensaje.exito}")
	public String msgExito;
	
	@Value("${parqueadero.mensaje.diaHabil}")
	public String msgDiaHabil;
	
	@Value("${parqueadero.mensaje.errorplaca}")
	public String errorPlaca;
	
	@Value("${parqueadero.capacidad.carro}")
	public int maxCarro;
	
	@Value("${parqueadero.capacidad.moto}")
	public int maxMoto;
	
	@Value("${parqueadero.topes.hora}")
	public int topeHora;
	
	@Value("${parqueadero.valor.hora.carro}")
	public int horaCarro;
	
	@Value("${parqueadero.valor.hora.moto}")
	public int horaMoto;
	
	@Value("${parqueadero.valor.dia.carro}")
	public int diaCarro;
	
	@Value("${parqueadero.valor.dia.moto}")
	public int diaMoto;
	
	@Value("${parqueadero.moto.cilindraje}")
	public int cilindraje;
	
	@Value("${parqueadero.moto.adicional}")
	public int adicional;
	
	@Value("${parqueadero.mensaje.codigo.exito}")
	public int exito;
	
	@Value("${parqueadero.mensaje.codigo.error}")
	public int error;
	
	@Value("${parqueadero.regla}")
	public String regla;

}
