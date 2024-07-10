package com.pedido.test.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.pedido.test.model.Articulo;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdenDto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
    private ClienteDto clienteDto;
    private Long ClienteId;
    private String codigo;
    private Long totalArticulos;
    private List<ArticuloDto> listaArituclos;
}
