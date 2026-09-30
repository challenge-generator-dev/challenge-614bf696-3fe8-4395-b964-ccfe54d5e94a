package com.pragma.productapi.exception;

public class DuplicateProductNameException extends RuntimeException {

    private final String productName;

    public DuplicateProductNameException(String productName) {
        super(String.format("Ya existe un producto registrado con el nombre: %s", productName));
        this.productName = productName;
    }

    public DuplicateProductNameException(String productName, String message) {
        super(message);
        this.productName = productName;
    }

    public DuplicateProductNameException(String productName, Throwable cause) {
        super(String.format("Ya existe un producto registrado con el nombre: %s", productName), cause);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "DuplicateProductNameException{" +
                "productName='" + productName + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}