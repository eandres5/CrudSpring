package com.pedido.test.interfaceServices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GenericService<T, E> {
	public List<T> findAll();

	public List<E> findAllDTo();

	public Page<T> findAll(Pageable pageable);

	public Page<E> findAllDto(Pageable pageable);

	public T save(T entity);

	public T saveDto(E dto);

	public T update(T entity);

	public T findOne(Long id);

	public void delete(Long id);

}

