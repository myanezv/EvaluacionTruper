package com.evaluacion.truper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDENPRODUCTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenProductos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="orden_id")
	private OrdenesCompra ordenesCompra;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Productos productos;
}
