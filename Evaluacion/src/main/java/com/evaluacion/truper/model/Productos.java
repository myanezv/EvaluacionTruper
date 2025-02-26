package com.evaluacion.truper.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int producto_id;
	@ManyToOne
	@JoinColumn(name="orden_id", nullable = false)
	private OrdenesCompra orden_id;
	private String codigo;
	private String descripcion;
	private double precio;
}
