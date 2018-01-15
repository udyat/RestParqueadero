package com.co.ceiba.restparqueadero.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name="vehiculos")
@EntityListeners(AuditingEntityListener.class)
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="placa")
	private String placa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_ingreso")
	private Date horaIngreso;

	private String propietario;

	//bi-directional many-to-one association to TiposVehiculo
	@ManyToOne
	@JoinColumn(name="fk_tipo_vehiculo")
	private TiposVehiculo tiposVehiculo;


	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getHoraIngreso() {
		return this.horaIngreso;
	}

	public void setHoraIngreso(Date horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public TiposVehiculo getTiposVehiculo() {
		return this.tiposVehiculo;
	}

	public void setTiposVehiculo(TiposVehiculo tiposVehiculo) {
		this.tiposVehiculo = tiposVehiculo;
	}

}