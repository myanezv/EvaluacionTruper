package com.evaluacion.truper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.truper.dto.ProductosDTO;
import com.evaluacion.truper.dto.ResponseDTO;
import com.evaluacion.truper.exception.NotFoundException;
import com.evaluacion.truper.service.ProductosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@GetMapping("/")
	@Operation(summary = "Obtener productos", description = "Devuelve una lista con todos los productos existantes")
	public ResponseEntity<ResponseDTO<List<ProductosDTO>>> findAll() {
		List<ProductosDTO> response = productosService.findAll();
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@PutMapping("/updatePrice/{id}")
	@Operation(summary = "Actualizar precio por id", description = "Actualiza el precio del producto por id")
	public ResponseEntity<ResponseDTO<ProductosDTO>> updatePrice(@PathVariable("id") int id, @Valid @RequestBody ProductosDTO productosDTO) {
		ProductosDTO response = productosService.updatePrice(id, productosDTO);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@PutMapping("/updatePriceByCode/{code}")
	@Operation(summary = "Actualizar precio por código", description = "Actualiza el precio del producto por código")
	public ResponseEntity<ResponseDTO<ProductosDTO>> updatePriceByCode(@PathVariable("code") String code, @Valid @RequestBody ProductosDTO productosDTO) {
		ProductosDTO response = productosService.updatePriceByCode(code, productosDTO);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@PutMapping("/update/{id}")
	@Operation(summary = "Actualizar producto", description = "Actualiza el producto por id")
	public ResponseEntity<ResponseDTO<ProductosDTO>> update(@PathVariable("id") int id, @Valid @RequestBody ProductosDTO productosDTO) {
		ProductosDTO response = productosService.update(id, productosDTO);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
