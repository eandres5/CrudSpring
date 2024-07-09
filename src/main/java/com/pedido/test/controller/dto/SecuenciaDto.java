package com.pedido.test.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecuenciaDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private Long longitud;
}
