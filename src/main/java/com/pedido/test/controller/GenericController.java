package com.pedido.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import com.pedido.test.interfaceServices.GenericService;

public class GenericController<T, D, S extends GenericService<T, D>> {

	@Autowired
	protected S service;

	@GetMapping(value = "/findOne/{id}")
	public ResponseEntity<?> findOne(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok().body(service.findOne(Long.valueOf(id)));
	}

	@GetMapping(value = "/findAllPage/{parametroLike}")
	public PageImpl<?> findAllPage(@PathVariable(name = "parametroLike") String parametroLike, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		if (parametroLike == null) {
			System.out.println("busqueda por LIKE");
			return null;
		} else {
			PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
			Page<D> pageResult = service.findAllDto(pageRequest);
			return new PageImpl<>(pageResult.getContent(), pageRequest, pageResult.getTotalElements());
		}
	}

	@GetMapping(value = "/findAllPage")
	public PageImpl<?> findAllPage(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
		Page<D> pageResult = service.findAllDto(pageRequest);
		return new PageImpl<>(pageResult.getContent(), pageRequest, pageResult.getTotalElements());
	}

}
