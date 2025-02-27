package com.evaluacion.truper.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenesCompraDTO {
	private int orden_id;
	
	@NotNull(message = "Sucursal requerida")
	private int sucursal_id;
	
	private String nombre_sucursal;
	
	@NotEmpty(message = "Productos requeridos")
	private List<ProductosDTO> productos;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@NotNull(message = "Fecha requerida")
	private Date fecha;
	
	private double total;
}
