package com.pedido.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pedido.test.model.DetalleOrdenArticulo;

public interface DetalleOrdenArticuloRepository extends PagingAndSortingRepository<DetalleOrdenArticulo, Long>{

}
