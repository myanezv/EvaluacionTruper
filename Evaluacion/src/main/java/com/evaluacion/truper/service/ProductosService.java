package com.evaluacion.truper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.truper.dto.ProductosDTO;
import com.evaluacion.truper.exception.NotFoundException;
import com.evaluacion.truper.model.Productos;
import com.evaluacion.truper.repository.ProductosRepository;

@Service
public class ProductosService {
	@Autowired
	ProductosRepository productosRepository;
	
	public List<ProductosDTO> findAll(){
		List<ProductosDTO> response = new ArrayList<ProductosDTO>();
		List<Productos> productos = productosRepository.findAll();
		
		if (!productos.isEmpty()) {
			response = productos.stream()
					.map(producto -> new ProductosDTO(
							producto.getProducto_id(),
							producto.getCodigo(),
							producto.getDescripcion(),
							producto.getPrecio()
							))
					.collect(Collectors.toList());
		}
		return response;
	}
	
	
	public ProductosDTO updatePrice(int id, ProductosDTO productosDTO) {
		ProductosDTO response = null;
		
		Productos producto = productosRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
		
		producto.setProducto_id(id);
		producto.setPrecio(productosDTO.getPrecio());
		Productos updated = productosRepository.save(producto);
		
		if (updated != null) {
			response = new ProductosDTO(
					updated.getProducto_id(),
					updated.getCodigo(),
					updated.getDescripcion(),
					updated.getPrecio()
					);
		}
		
		return response;
	}
	
	public ProductosDTO updatePriceByCode(String code, ProductosDTO productosDTO) {
		ProductosDTO response = null;
		
		Productos producto = productosRepository.findByCode(code)
				.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + code));
		
		producto.setPrecio(productosDTO.getPrecio());
		
		Productos updated = productosRepository.save(producto);
		
		if (updated != null) {
			response = new ProductosDTO(
					updated.getProducto_id(),
					updated.getCodigo(),
					updated.getDescripcion(),
					updated.getPrecio()
					);
		}
		
		return response;
	}
	
	
	public ProductosDTO update(int id, ProductosDTO productosDTO) {
		ProductosDTO response = null;
		
		Productos producto = productosRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
		
		producto.setProducto_id(id);
		producto.setCodigo(productosDTO.getCodigo());
		producto.setDescripcion(productosDTO.getDescripcion());
		producto.setPrecio(productosDTO.getPrecio());
		Productos updated = productosRepository.save(producto);
		
		if (updated != null) {
			response = new ProductosDTO(
					updated.getProducto_id(),
					updated.getCodigo(),
					updated.getDescripcion(),
					updated.getPrecio()
					);
		}
		
		return response;
	}
}
