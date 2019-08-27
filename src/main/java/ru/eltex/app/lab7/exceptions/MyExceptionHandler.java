package ru.eltex.app.lab7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

/**
 * @ControllerAdvice используется для глобальной обработки ошибок в приложении Spring MVC.
 * Он также имеет полный контроль над телом ответа и кодом состояния.
 */

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * @ExceptionHandler. Эта аннотация обрабатывает исключение, произошедшее в контроллере, как обычный запрос
     *
     */

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity handleNullExeptions() {
        return new ResponseEntity("1", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    private ResponseEntity wrongWay() {
        return new ResponseEntity("3", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    private ResponseEntity corruptedFile() {
        return new ResponseEntity("2", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
