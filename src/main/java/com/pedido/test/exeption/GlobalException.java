package com.pedido.test.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(StockException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetalles> StockException(StockException exception){
		ErrorDetalles mensaje = new ErrorDetalles(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
	}
}