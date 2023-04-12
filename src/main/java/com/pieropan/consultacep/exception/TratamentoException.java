package com.pieropan.consultacep.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoException {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity illegalArgumentException() {
        return ResponseEntity.badRequest().body("CEP não encontrado!");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getFieldErrors().get(0).getDefaultMessage());
    }
}