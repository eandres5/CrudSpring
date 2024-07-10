package com.pedido.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedido.test.controller.dto.OrdenDto;
import com.pedido.test.exeption.StockException;
import com.pedido.test.interfaceServices.ArticuloService;
import com.pedido.test.interfaceServices.ClienteService;
import com.pedido.test.interfaceServices.DetalleOrdenArticuloService;
import com.pedido.test.interfaceServices.OrdenService;
import com.pedido.test.model.Articulo;
import com.pedido.test.model.DetalleOrdenArticulo;
import com.pedido.test.model.Orden;
import com.pedido.test.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenRepository orenRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private DetalleOrdenArticuloService detalleOrdArtService;
	
	@Override
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenDto> findAllDTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Orden> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<OrdenDto> findAllDto(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden save(Orden entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden saveDto(OrdenDto dto) {
		return null;
	}

	@Override
	public Orden update(Orden entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Orden saveOrden(Orden orden) throws StockException {
		return null;
	}

	@Override
	public Orden saveOrden(OrdenDto ordenDto) throws StockException {
		Orden orden = new Orden();	
		orden.setCliente(clienteService.findOne(ordenDto.getId()));
		orden.setCodigo(ordenDto.getCodigo());
		orden.setTotalArticulos(ordenDto.getTotalArticulos());
		save(orden);
		
		try {
			ordenDto.getListaArituclos().forEach(x->{
				Articulo articulo = articuloService.findOne(x.getId());
				DetalleOrdenArticulo detalle = new DetalleOrdenArticulo();
				if(x.getCantidad() < 0) {
					throw new StockException("Stcock insuficiente");
				} else {
					Long stockNuevo = articulo.getStock() - x.getCantidad();
					if(stockNuevo < 0) {
						throw new StockException("Stcock insuficiente articulos mayores al stock");
					} else {
						detalle.setOrden(orden);
						detalle.setArticulo(articulo);
						detalle.setCantidadAritculo(x.getCantidad());
						detalleOrdArtService.save(detalle);
						
						articulo.setStock(stockNuevo);
						articuloService.save(articulo);
					}
				}
			});
			
		}catch (Exception e) {
			throw new StockException(e.getMessage());
		}
		return null;
	}


}
