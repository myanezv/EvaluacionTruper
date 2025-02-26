package com.evaluacion.truper.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenesCompra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orden_id;
	@ManyToOne
	@JoinColumn(name="sucursal_id", nullable = false)
	private Sucursal sucursal;
//	@OneToMany
//	@JoinColumn(name="producto_id", nullable = false)
//	private List<Productos> producto;
	private Date fecha;
	private double total;
}
