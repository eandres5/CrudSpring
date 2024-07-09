package com.pedido.test.interfaceServices;

import com.pedido.test.controller.dto.SecuenciaDto;
import com.pedido.test.model.Secuencia;

public interface SecuenciaService  extends GenericService<Secuencia, SecuenciaDto>{

	String getSecuencial(String codigo);

	Secuencia findByCodigo(String codigo);

}
