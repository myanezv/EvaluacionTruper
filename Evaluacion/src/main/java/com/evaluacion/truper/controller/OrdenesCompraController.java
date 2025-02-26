package com.evaluacion.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.truper.dto.OrdenesCompraDTO;
import com.evaluacion.truper.dto.ResponseDTO;
import com.evaluacion.truper.service.OrdenesCompraService;

@RestController
@RequestMapping("/ordenes")
public class OrdenesCompraController {
	@Autowired
	OrdenesCompraService ordenesCompraService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<OrdenesCompraDTO>> getOrdenById(@PathVariable("id") int id){
		OrdenesCompraDTO response = ordenesCompraService.getOrdenById(id);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDTO<OrdenesCompraDTO>> saveOrden(@RequestBody OrdenesCompraDTO ordenesCompraDTO){
		OrdenesCompraDTO response = ordenesCompraService.saveOrden(ordenesCompraDTO);
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
	
}
