package guru.springframework.employee.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> constrainstErrorHandler(ConstraintViolationException ex){
        List<String> errorList = new ArrayList<>();
        ex.getConstraintViolations().forEach( e->errorList.add(e.getPropertyPath()+" ==> "+e.getMessage()));
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> bindErrorHandler(BindException ex){
        List<String> errorList = new ArrayList<>();
        ex.getAllErrors().forEach( e->errorList.add(e.getDefaultMessage()));
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
