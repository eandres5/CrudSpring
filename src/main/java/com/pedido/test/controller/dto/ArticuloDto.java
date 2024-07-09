package com.pedido.test.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String codigo;
	private Double precioUnitario;
}
