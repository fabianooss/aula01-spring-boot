package org.senac.aula01.controller;

import org.senac.aula01.vo.ErroValidacao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<FieldError> erros = ex.getBindingResult().getFieldErrors();
        ErroValidacao v = new ErroValidacao();
        erros.stream().forEach(e -> v.add(e.getField().toString() + " " + e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(v);
    }


}
