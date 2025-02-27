package com.evaluacion.truper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluacion.truper.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
	@Query("SELECT s FROM Sucursal s WHERE s.sucursal_id=:sucursal_id")
	Sucursal findSucursalById(@Param("sucursal_id") int sucursal_id);
	
	@Query("SELECT s FROM Sucursal s WHERE s.nombre=:nombre")
	Optional<Sucursal> findByName(@Param("nombre") String nombre);
}
