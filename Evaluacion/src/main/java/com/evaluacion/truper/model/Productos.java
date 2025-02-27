package com.evaluacion.truper.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int producto_id;
	
	@ManyToMany(mappedBy="productos")
	private List<OrdenesCompra> orden_id;
	
	private String codigo;
	
	private String descripcion;
	
	private double precio;
}
