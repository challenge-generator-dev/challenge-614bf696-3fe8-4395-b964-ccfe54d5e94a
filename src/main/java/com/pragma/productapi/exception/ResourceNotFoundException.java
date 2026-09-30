package com.pragma.productapi.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceType;
    private final String searchCriteria;
    private final UUID resourceId;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceType = "Resource";
        this.searchCriteria = message;
        this.resourceId = null;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.resourceType = "Resource";
        this.searchCriteria = message;
        this.resourceId = null;
    }

    public ResourceNotFoundException(String resourceType, String fieldName, Object fieldValue) {
        super(String.format("%s no encontrado con %s: %s", resourceType, fieldName, fieldValue));
        this.resourceType = resourceType;
        this.searchCriteria = String.format("%s = %s", fieldName, fieldValue);
        this.resourceId = fieldValue instanceof UUID ? (UUID) fieldValue : null;
    }

    public ResourceNotFoundException(String resourceType, UUID id) {
        super(String.format("%s no encontrado con ID: %s", resourceType, id));
        this.resourceType = resourceType;
        this.searchCriteria = "ID";
        this.resourceId = id;
    }

    public ResourceNotFoundException(String resourceType, String fieldName, Object fieldValue, Throwable cause) {
        super(String.format("%s no encontrado con %s: %s", resourceType, fieldName, fieldValue), cause);
        this.resourceType = resourceType;
        this.searchCriteria = String.format("%s = %s", fieldName, fieldValue);
        this.resourceId = fieldValue instanceof UUID ? (UUID) fieldValue : null;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public boolean hasResourceId() {
        return resourceId != null;
    }

    @Override
    public String toString() {
        return String.format("ResourceNotFoundException{type='%s', criteria='%s', id=%s, message='%s'}",
                resourceType, searchCriteria, resourceId, getMessage());
    }
}