package com.evaluacion.truper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.truper.dto.OrdenesCompraDTO;
import com.evaluacion.truper.model.OrdenesCompra;
import com.evaluacion.truper.model.Sucursal;
import com.evaluacion.truper.repository.OrdenesCompraRepository;

@Service
public class OrdenesCompraService {
	@Autowired
	OrdenesCompraRepository ordenesCompraRepository;
	
	public OrdenesCompraDTO getOrdenById(int id) {
		OrdenesCompraDTO response = null;
		
		OrdenesCompra orden = ordenesCompraRepository.findOrdenById(id);
		
		if (orden != null) {
			response = new OrdenesCompraDTO();
			response.setOrden_id(orden.getOrden_id());
			response.setSucursal_id(orden.getSucursal().getSucursal_id());
			response.setNombre_sucursal(orden.getSucursal().getNombre());
			response.setFecha(orden.getFecha());
			response.setTotal(orden.getTotal());
		}
		
		return response;
	}
	
	public OrdenesCompraDTO saveOrden(OrdenesCompraDTO ordenesCompraDTO) {
		OrdenesCompraDTO response = null;
		OrdenesCompra orden = new OrdenesCompra();
		orden.setOrden_id(ordenesCompraDTO.getOrden_id());
		
		Sucursal sucursal = new Sucursal();
		sucursal.setSucursal_id(ordenesCompraDTO.getSucursal_id());
		
		orden.setSucursal(sucursal);
		orden.setFecha(ordenesCompraDTO.getFecha());
		orden.setTotal(ordenesCompraDTO.getTotal());
		
		OrdenesCompra ordenSaved = ordenesCompraRepository.save(orden);
		
		if(ordenSaved != null) {
			response = new OrdenesCompraDTO();
			response.setOrden_id(ordenSaved.getOrden_id());
			response.setSucursal_id(ordenSaved.getSucursal().getSucursal_id());
			response.setNombre_sucursal(ordenSaved.getSucursal().getNombre());
			response.setFecha(ordenSaved.getFecha());
			response.setTotal(ordenSaved.getTotal());
		}
		
		return response;
	}
}
