package com.pedido.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pedido.test.controller.dto.ClienteDto;
import com.pedido.test.interfaceServices.ClienteService;
import com.pedido.test.model.Cliente;
import com.pedido.test.repository.ClienteRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDto> findAllDTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public Page<ClienteDto> findAllDto(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente save(Cliente entity) {
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente saveDto(ClienteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setNombres(dto.getNombres() != null ? dto.getNombres() : null);
		cliente.setApellidos(dto.getApellidos() != null ? dto.getApellidos() : null);
		cliente.setTelefono(dto.getTelefono() != null ? dto.getTelefono() : null);
		cliente.setDireccion(dto.getDireccion() != null ? dto.getDireccion() : null);
		cliente.setFechaCreacion(new Date());
		save(cliente);
		return cliente;
	}

	@Override
	public Cliente update(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteRepository.findById(id);

	}

	@Override
	public void delete(Long id) {
		 clienteRepository.deleteById(id);		
	}

	@Override
	public Page<Cliente> findAllClientes(Pageable pageable) {
		return clienteRepository.findAll(new Specification<Cliente>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
	}

}
