package com.evaluacion.truper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.truper.dto.ResponseDTO;
import com.evaluacion.truper.dto.SucursalDTO;
import com.evaluacion.truper.service.SucursalService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
	@Autowired
	SucursalService sucursalService;
	
	@GetMapping("/")
	@Operation(summary = "Obtener sucursales", description = "Obtiene una lista de todas las sucursales")
	public ResponseEntity<ResponseDTO<List<SucursalDTO>>> getSucursales(){
		List<SucursalDTO> response = sucursalService.findAll();
		return ResponseEntity.ok(new ResponseDTO<>(response));
	}
}
