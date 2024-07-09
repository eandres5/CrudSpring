package com.pedido.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pedido.test.model.Secuencia;

@Repository
public interface SecuenciaRepository extends PagingAndSortingRepository<Secuencia, Long>{

	Secuencia findByCodigo(String codigo);

}
