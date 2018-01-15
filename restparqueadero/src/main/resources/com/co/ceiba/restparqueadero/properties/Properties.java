package com.co.ceiba.restparqueadero.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	@Value("${parqueadero.mensaje.maxmotos}")
	public String msgMaxMotos;	
	
	@Value("${parqueadero.mensaje.maxcarros}")
	public String msgMaxCarros;
	
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
