package com.co.ceiba.restparqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.co.ceiba.restparqueadero.model.Vehiculo;

/**
 * Interface del Repositorio de JpaRepositoy para el acceso a los datos del parqueadero en BD
 * @author: Daniel.Mejia
 */
@Repository												     
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Integer>{
	
	/**
	 * Query que consulta cuantos vehiculos hay actualmente en el parqueadero
	 */
	@Query(value = "SELECT count(*) FROM Vehiculos WHERE fk_tipo_vehiculo = ?1 and hora_salida IS NULL", nativeQuery = true)
	  int contarVehiculos(int idTipo);
	
	/**
	 * Query que consulta por placa un vehiculo que se encuentra en el parqueadero
	 */
	@Query(value = "SELECT * FROM Vehiculos WHERE placa = ?1 and hora_salida IS NULL", nativeQuery = true) 
	Vehiculo buscarVehiculo(String placa);
	
	/**
	 * Query que consulta todos los vehiculos que hay en el parqueadero
	 */
	@Query(value = "SELECT * FROM Vehiculos WHERE hora_salida IS NULL", nativeQuery = true) 
	List<Vehiculo> buscarTodasVehiculo();

}
