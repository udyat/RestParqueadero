package com.co.ceiba.restparqueadero.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * Clase de persistencia para la tabla de vehiculos de la base de datos.
 */
@Entity
@Table(name="vehiculos")
@EntityListeners(AuditingEntityListener.class)
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="serial_id")
	private int serialId;
	
	@Column(name="placa")
	private String placa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_ingreso")
	private Date horaIngreso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_salida")
	private Date horaSalida;
	
	@Column(name="propietario")
	private String propietario;
	
	@Column(name="cilindraje")
	private Integer cilindraje;

	
	@ManyToOne
	@JoinColumn(name="fk_tipo_vehiculo")
	private TiposVehiculo tiposVehiculo;

	public int getSerialId() {
		return this.serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	
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
	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	public Integer getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
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