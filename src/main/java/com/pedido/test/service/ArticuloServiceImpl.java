package com.pedido.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pedido.test.controller.dto.ArticuloDto;
import com.pedido.test.interfaceServices.ArticuloService;
import com.pedido.test.interfaceServices.SecuenciaService;
import com.pedido.test.model.Articulo;
import com.pedido.test.repository.ArticuloRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ArticuloServiceImpl implements ArticuloService{

	@Autowired
	private ArticuloRepository articuloRepository;
	@Autowired
	private SecuenciaService secuenciaService;
	
	@Override
	public List<Articulo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticuloDto> findAllDTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Articulo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ArticuloDto> findAllDto(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo save(Articulo entity) {
		return articuloRepository.save(entity);
	}

	@Override
	public Articulo saveDto(ArticuloDto dto) {
//		try{
			Articulo articulo = new Articulo();
			// aqui reviso sino tiene id es un articulo nuevo
			// caso contrario se debe actualizar
			if(dto.getId() == null) {
				articulo.setCodigo(secuenciaService.getSecuencial("AR-"));
				articulo.setNombre(dto.getNombre() != null ? dto.getNombre(): null);
				articulo.setPrecioUnitario(new BigDecimal(dto.getPrecioUnitario()));
				articulo.setFechaCreacion(new Date());
				save(articulo);
				return articulo;
			}else {
				Articulo articuloUpdate = findOne(dto.getId());
				articuloUpdate.setNombre(dto.getNombre());
				articuloUpdate.setPrecioUnitario(new BigDecimal(dto.getPrecioUnitario()));
				articuloUpdate.setFechaModificacion(new Date());
				save(articuloUpdate);
				return articuloUpdate;
			}
//		}catch() {
//			
//		}
		
	}

	@Override
	public Articulo update(Articulo entity) {
		return null;
	}

	@Override
	public Articulo findOne(Long id) {
		return articuloRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		articuloRepository.deleteById(id);		
	}
	
	@Override
	public Page<Articulo> findAllArticulos(Pageable pageable) {
		return articuloRepository.findAll(new Specification<Articulo>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Articulo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
	}

}
