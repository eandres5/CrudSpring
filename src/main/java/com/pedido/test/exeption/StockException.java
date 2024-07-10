package com.pedido.test.exeption;

public class StockException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StockException(String message) {
        super(message);
    }
}
