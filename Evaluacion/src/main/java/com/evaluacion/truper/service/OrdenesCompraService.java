package com.evaluacion.truper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.truper.dto.OrdenesCompraDTO;
import com.evaluacion.truper.dto.ProductosDTO;
import com.evaluacion.truper.exception.NotFoundException;
import com.evaluacion.truper.model.OrdenesCompra;
import com.evaluacion.truper.model.Productos;
import com.evaluacion.truper.model.Sucursal;
import com.evaluacion.truper.repository.OrdenesCompraRepository;
import com.evaluacion.truper.repository.ProductosRepository;
import com.evaluacion.truper.repository.SucursalRepository;

@Service
public class OrdenesCompraService {
	@Autowired
	OrdenesCompraRepository ordenesCompraRepository;
	
	@Autowired
	ProductosRepository productosRepository;
	
	@Autowired
	SucursalRepository sucursalRepository;
	
	public OrdenesCompraDTO getOrdenById(int id) {
		OrdenesCompraDTO response = null;
		
		OrdenesCompra orden = ordenesCompraRepository.findOrdenById(id);
		
		if (orden != null) {
			response = new OrdenesCompraDTO();
			response.setOrden_id(orden.getOrden_id());
			response.setSucursal_id(orden.getSucursal().getSucursal_id());
			response.setNombre_sucursal(orden.getSucursal().getNombre());
			response.setProductos(
					orden.getProductos().stream()
					.map(prod -> new ProductosDTO(
							prod.getProducto_id(),
							prod.getCodigo(),
							prod.getDescripcion(),
							prod.getPrecio()
							))
					.collect(Collectors.toList())
					);
			response.setFecha(orden.getFecha());
			response.setTotal(orden.getTotal());
		}
		
		return response;
	}
	
	public OrdenesCompraDTO saveOrden(OrdenesCompraDTO ordenesCompraDTO) {
		OrdenesCompraDTO response = null;
		OrdenesCompra orden = new OrdenesCompra();
		
		// Validar que la orden contenga al menos un producto
		if (ordenesCompraDTO.getProductos() == null || ordenesCompraDTO.getProductos().isEmpty()) {
			throw new NotFoundException("La orden de compra debe contener al menos un producto.");
		}
		
		// Validar que los productos existan
		List<Productos> productos = ordenesCompraDTO.getProductos().stream()
		        .map(producto -> productosRepository.findById(producto.getProducto_id())
		            .orElseThrow(() -> new NotFoundException("Producto no encontrado: " + producto.getProducto_id())))
		        .collect(Collectors.toList());
		
		orden.setProductos(productos);
		
		// Validamos de sucursal por nombre
		Sucursal sucursal = sucursalRepository.findByName(ordenesCompraDTO.getNombre_sucursal())
				.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + ordenesCompraDTO.getSucursal_id()));
		
		//Validación de sucursal por id
//		Sucursal sucursal = sucursalRepository.findById(ordenesCompraDTO.getSucursal_id())
//				.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + ordenesCompraDTO.getSucursal_id()));
		
		
		orden.setSucursal(sucursal);
		
		orden.setOrden_id(ordenesCompraDTO.getOrden_id());
		
		orden.setFecha(ordenesCompraDTO.getFecha());
		orden.setTotal(ordenesCompraDTO.getTotal());
		
		OrdenesCompra ordenSaved = ordenesCompraRepository.save(orden);
		
		if(ordenSaved != null) {
			response = new OrdenesCompraDTO();
			response.setOrden_id(ordenSaved.getOrden_id());
			response.setSucursal_id(ordenSaved.getSucursal().getSucursal_id());
			response.setNombre_sucursal(ordenSaved.getSucursal().getNombre());
			response.setProductos(
					ordenSaved.getProductos().stream()
					.map(prod -> new ProductosDTO(
							prod.getProducto_id(),
							prod.getCodigo(),
							prod.getDescripcion(),
							prod.getPrecio()
							))
					.collect(Collectors.toList())
					);
			response.setFecha(ordenSaved.getFecha());
			response.setTotal(ordenSaved.getTotal());
		}
		
		return response;
	}
}
