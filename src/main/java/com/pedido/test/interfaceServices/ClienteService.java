package com.pedido.test.interfaceServices;

import com.pedido.test.controller.dto.ClienteDto;
import com.pedido.test.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService extends GenericService<Cliente, ClienteDto>{

	Page<Cliente> findAllClientes(Pageable pageable);

}
