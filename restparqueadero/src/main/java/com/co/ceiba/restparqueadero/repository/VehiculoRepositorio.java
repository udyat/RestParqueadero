package com.co.ceiba.restparqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.co.ceiba.restparqueadero.model.Vehiculo;

@Repository												     
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Integer>{
	
	
	@Query(value = "SELECT count(*) FROM Vehiculos WHERE fk_tipo_vehiculo = ?1 and hora_salida IS NULL", nativeQuery = true)
	  int contarVehiculos(int idTipo);
	
	@Query(value = "SELECT * FROM Vehiculos WHERE placa = ?1 and hora_salida IS NULL", nativeQuery = true) 
	Vehiculo buscarVehiculo(String placa);

}
