package com.evaluacion.truper.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenesCompraDTO {
	private int orden_id;
	private int sucursal_id;
	private String nombre_sucursal;
	private Date fecha;
	private double total;
}
