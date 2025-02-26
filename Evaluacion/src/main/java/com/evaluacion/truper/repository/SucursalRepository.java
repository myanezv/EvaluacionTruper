package com.evaluacion.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.truper.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{

}
