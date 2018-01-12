package com.co.ceiba.restparqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.ceiba.restparqueadero.model.TiposVehiculo;
import com.co.ceiba.restparqueadero.model.Vehiculo;

@Repository												     
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String>{
	
	int countByTiposVehiculo(TiposVehiculo tiposVehiculo);

	
	

}
