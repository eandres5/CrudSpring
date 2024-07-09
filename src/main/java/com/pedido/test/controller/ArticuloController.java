package com.pedido.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.test.controller.dto.ArticuloDto;
import com.pedido.test.interfaceServices.ArticuloService;
import com.pedido.test.model.Articulo;

@RestController
@RequestMapping("apiArticulo/")
public class ArticuloController extends GenericController<Articulo, ArticuloDto, ArticuloService>{

	@PostMapping(value = "/saveArticulo")
	public ResponseEntity<?> save(@RequestBody ArticuloDto articuloDto) {
		Map<String, Object> responseMap = new HashMap<>();
		if (service.saveDto(articuloDto) != null) {
			responseMap.put("mensaje", "Registro actualizado");
			return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
		} else {
			responseMap.put("mensaje", "Error");
			return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listArticulos")
	public PageImpl<?> listPage(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("fechaCreacion").descending());
		Page<Articulo> pageResult;
		pageResult = service.findAllArticulos(pageRequest);
		List<Articulo> todos = pageResult.getContent();
		List<ArticuloDto> todosDTO = new ArrayList<>();
		todos.forEach(x -> {
			ArticuloDto articuloDtoResp = new ArticuloDto();
			articuloDtoResp.setId(x.getId());
			articuloDtoResp.setCodigo(x.getCodigo());
			articuloDtoResp.setNombre(x.getNombre());
			articuloDtoResp.setPrecioUnitario(Double.parseDouble(x.getPrecioUnitario() + ""));
			todosDTO.add(articuloDtoResp);
		});
		return new PageImpl<>(todosDTO, pageRequest, pageResult.getTotalElements());
	}
	
	@DeleteMapping("/deleteArticulo/{id}")
    public void eliminarArticulo(@PathVariable Long id) {
		service.delete(id);
    }
	
}
