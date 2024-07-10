package com.pedido.test.interfaceServices;

import com.pedido.test.controller.dto.OrdenDto;
import com.pedido.test.exeption.StockException;
import com.pedido.test.model.Orden;

public interface OrdenService extends GenericService<Orden, OrdenDto>{

	Orden saveOrden(OrdenDto ordenDto) throws StockException ;
}
