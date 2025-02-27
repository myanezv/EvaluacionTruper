package com.evaluacion.truper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDTO {
	private int producto_id;
		
	private String codigo;
	
	private String descripcion;
	
	private double precio;
}
