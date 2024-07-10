package com.pedido.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.test.controller.dto.OrdenDto;
import com.pedido.test.exeption.StockException;
import com.pedido.test.interfaceServices.OrdenService;
import com.pedido.test.model.Orden;

@RestController
@RequestMapping("apiOrden/")
public class OrdenController extends GenericController<Orden, OrdenDto, OrdenService>{

	@PostMapping(value = "/saveOrden")
	public ResponseEntity<?> save(@RequestBody OrdenDto ordenDto) throws StockException {
		Map<String, Object> responseMap = new HashMap<>();
		if (service.saveOrden(ordenDto) != null) {
			responseMap.put("mensaje", "Registro actualizado");
			return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
		} else {
			responseMap.put("mensaje", "Error");
			return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
