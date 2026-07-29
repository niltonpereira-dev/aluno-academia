package br.com.niltonpereira_dev.aluno_academia.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
