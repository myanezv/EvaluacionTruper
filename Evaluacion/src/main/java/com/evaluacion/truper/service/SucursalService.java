package com.evaluacion.truper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.truper.dto.SucursalDTO;
import com.evaluacion.truper.model.Sucursal;
import com.evaluacion.truper.repository.SucursalRepository;

@Service
public class SucursalService {
	@Autowired
	SucursalRepository sucursalRepository;

	public List<SucursalDTO> findAll(){
		List<SucursalDTO>response  = null;
		List<Sucursal> sucursales = sucursalRepository.findAll();
		if (!sucursales.isEmpty()) {
			response = sucursales.stream()
					.map(sucursal -> new SucursalDTO(
					sucursal.getSucursal_id(),
					sucursal.getNombre()
					))
					.collect(Collectors.toList());			
		}
		
		return response;
	}
}
