package com.evaluacion.truper.dto;

import com.evaluacion.truper.model.Sucursal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO  <T>{
	private T data;
}
