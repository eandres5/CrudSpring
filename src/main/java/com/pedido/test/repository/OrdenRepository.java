package com.pedido.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pedido.test.model.Orden;

@Repository
public interface OrdenRepository  extends PagingAndSortingRepository<Orden, Long>{

}
