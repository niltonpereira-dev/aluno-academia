package br.com.niltonpereira_dev.aluno_academia.handler;

import br.com.niltonpereira_dev.aluno_academia.exception.ErroResponse;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import org.apache.coyote.BadRequestException;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErroResponse> handleBadRequestException(BadRequestException ex){
        ErroResponse response = ErroResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResponse> handleNotFoundException(NotFoundException ex){
        ErroResponse response = ErroResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    public ResponseEntity<ErroResponse> handleException(Exception ex){
        ErroResponse response = ErroResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
