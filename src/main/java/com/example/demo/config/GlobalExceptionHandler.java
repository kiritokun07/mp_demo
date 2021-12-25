package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public R<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.newFailedResponse(999, String.valueOf(e));
    }

}
