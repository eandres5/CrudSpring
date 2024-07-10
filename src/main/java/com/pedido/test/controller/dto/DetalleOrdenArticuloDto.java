package com.pedido.test.controller.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleOrdenArticuloDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private OrdenDto ordenDto;
	private ArticuloDto articuloDto;
	private Long cantidadAritculo;
	
}
