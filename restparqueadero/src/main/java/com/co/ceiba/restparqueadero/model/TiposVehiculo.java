package com.co.ceiba.restparqueadero.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla de tipos_vehiculo de la base de datos.
 */
@Entity
@Table(name="tipos_vehiculo")
@NamedQuery(name="TiposVehiculo.findAll", query="SELECT t FROM TiposVehiculo t")
public class TiposVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_vehiculo")
	private int idTipoVehiculo;

	private String descripcion;


	public int getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}