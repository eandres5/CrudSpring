package com.pedido.test.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String direccion;
}
