package com.evaluacion.truper.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDENESCOMPRA")
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
	
	@ManyToMany
	@JoinTable(name="ordenproductos", joinColumns=@JoinColumn(name="orden_id"),
	inverseJoinColumns = @JoinColumn(name = "producto_id") )
	private List<Productos> productos;
	
	private Date fecha;
	
	private double total;
	
	//Calcular el total de la orden de compra
	@PrePersist // Anotación que ejecuta el método antes de insertar
    @PreUpdate  // Anotación que ejecuta el método antes de actualizar
    public void calcularTotal() {
        this.total = productos.stream()
                              .mapToDouble(Productos::getPrecio)
                              .sum();
    }
}
