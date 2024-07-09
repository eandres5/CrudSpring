package com.pedido.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.test.controller.dto.ClienteDto;
import com.pedido.test.interfaceServices.ClienteService;
import com.pedido.test.model.Cliente;

@RestController
@RequestMapping("api/")
public class ClienteController extends GenericController<Cliente, ClienteDto, ClienteService>{

	@PostMapping(value = "/saveCliente")
	public ResponseEntity<?> save(@RequestBody ClienteDto clienteDto) {
		Map<String, Object> responseMap = new HashMap<>();
		if (service.saveDto(clienteDto) != null) {
			responseMap.put("mensaje", "Registro actualizado");
			return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
		} else {
			responseMap.put("mensaje", "Error");
			return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listClientes")
	public PageImpl<?> listPage(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("fechaCreacion").descending());
		Page<Cliente> pageResult;
		pageResult = service.findAllClientes(pageRequest);
		List<Cliente> todos = pageResult.getContent();
		List<ClienteDto> todosDTO = new ArrayList<>();
		todos.forEach(x -> {
			ClienteDto clienteDtoResp = new ClienteDto();
			clienteDtoResp.setId(x.getId());
			clienteDtoResp.setNombres(x.getNombres());
			clienteDtoResp.setApellidos(x.getApellidos());
			clienteDtoResp.setDireccion(x.getDireccion());
			clienteDtoResp.setTelefono(x.getTelefono());
			todosDTO.add(clienteDtoResp);
		});
		return new PageImpl<>(todosDTO, pageRequest, pageResult.getTotalElements());
	}
	
	@DeleteMapping("/deleteCliente/{id}")
    public void eliminarCliente(@PathVariable Long id) {
		service.delete(id);
    }

}
