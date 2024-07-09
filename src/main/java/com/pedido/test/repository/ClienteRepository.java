package com.pedido.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pedido.test.model.Cliente;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	@Transactional()
	public Page<Cliente> findAll(Specification<Cliente> specification, Pageable pageable);

	public Cliente save(Cliente entity);

	public void deleteById(Long id);

}
