package dev.itltcanz.app.model.response;

public record HttpErrorResponse(int code, String type, String message) {}
