package com.evaluacion.truper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluacion.truper.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{
	@Query("SELECT p FROM Productos p WHERE p.codigo=:codigo")
	Optional<Productos> findByCode(@Param("codigo") String orden_id);
}
