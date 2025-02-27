package com.evaluacion.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.truper.dto.OrdenesCompraDTO;
import com.evaluacion.truper.dto.ResponseDTO;
import com.evaluacion.truper.exception.NotFoundException;
import com.evaluacion.truper.service.OrdenesCompraService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordenes")
public class OrdenesCompraController {
	@Autowired
	OrdenesCompraService ordenesCompraService;
	
	@GetMapping("/{id}")
	@Operation(summary = "Obtener orden de compra por id", description = "Obtiene una orden de compra por id")
	public ResponseEntity<ResponseDTO<OrdenesCompraDTO>> getOrdenById(@PathVariable("id") int id){
		try {}catch(Exception e) {}
		OrdenesCompraDTO response = ordenesCompraService.getOrdenById(id);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@PostMapping("/save")
	@Operation(summary = "Guardar orden de compra", description = "Guarda una orden de compra")
	public ResponseEntity<ResponseDTO<OrdenesCompraDTO>> saveOrden(@Valid @RequestBody OrdenesCompraDTO ordenesCompraDTO){
		OrdenesCompraDTO response = ordenesCompraService.saveOrden(ordenesCompraDTO);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
	
}
