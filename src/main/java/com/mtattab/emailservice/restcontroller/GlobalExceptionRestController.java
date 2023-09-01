package com.mtattab.emailservice.restcontroller;

import com.mtattab.emailservice.model.ResponseRestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionRestController {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseRestModel> exceptionHandler(Exception exception){
        exception.printStackTrace();
        ResponseRestModel response = new ResponseRestModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
