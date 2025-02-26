package com.evaluacion.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluacion.truper.model.OrdenesCompra;

@Repository
public interface OrdenesCompraRepository extends JpaRepository<OrdenesCompra, Integer>{
	@Query("SELECT c FROM OrdenesCompra c WHERE c.orden_id=:orden_id")
	OrdenesCompra findOrdenById(@Param("orden_id") int orden_id);
}
