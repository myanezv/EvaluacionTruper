package com.evaluacion.truper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SUCURSAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sucursal_id;
	private String nombre;
}
