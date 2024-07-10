package com.pedido.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pedido.test.model.Articulo;
import com.pedido.test.model.Cliente;

@Repository
public interface ArticuloRepository  extends PagingAndSortingRepository<Articulo, Long> {

	Articulo save(Articulo entity);

	Page<Articulo> findAll(Specification<Articulo> specification, Pageable pageable);

	void deleteById(Long id);

	Articulo findById(Long id);

}
