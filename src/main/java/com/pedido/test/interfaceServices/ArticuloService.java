package com.pedido.test.interfaceServices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pedido.test.controller.dto.ArticuloDto;
import com.pedido.test.model.Articulo;
import com.pedido.test.model.Cliente;

public interface ArticuloService extends GenericService<Articulo, ArticuloDto>{

	Page<Articulo> findAllArticulos(Pageable pageable);

}
