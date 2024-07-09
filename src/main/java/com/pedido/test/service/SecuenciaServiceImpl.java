package com.pedido.test.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedido.test.controller.dto.SecuenciaDto;
import com.pedido.test.interfaceServices.SecuenciaService;
import com.pedido.test.model.Secuencia;
import com.pedido.test.repository.SecuenciaRepository;


@Service
public class SecuenciaServiceImpl implements SecuenciaService{
	
	@Autowired
	SecuenciaRepository secuenciaRepository;
	
	@Override
	public List<Secuencia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecuenciaDto> findAllDTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Secuencia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SecuenciaDto> findAllDto(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Secuencia save(Secuencia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Secuencia saveDto(SecuenciaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Secuencia update(Secuencia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Secuencia findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSecuencial(String codigo) {
		Secuencia secuencia = findByCodigo(codigo);
		String numero = StringUtils.leftPad("" + secuencia.getNumero(), secuencia.getLongitud().intValue(), '0');
		secuencia.setNumero(secuencia.getNumero() + 1);
		save(secuencia);
		return secuencia.getCodigo() != null ? secuencia.getCodigo() + numero : numero;
	}

	@Override
	public Secuencia findByCodigo(String codigo) {
		return secuenciaRepository.findByCodigo(codigo);
	}

}
