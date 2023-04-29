package io.github.brunoyillli.gestaofuncionarios.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.brunoyillli.gestaofuncionarios.exception.ErrorMessage;
import io.github.brunoyillli.gestaofuncionarios.exception.FuncionarioException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleNullPointerException(NullPointerException e) {
		return new ErrorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
		return new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(FuncionarioException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleFuncionarioNotFoundException(FuncionarioException e) {
		return new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value());
	}
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        return new ErrorMessage(errors, HttpStatus.BAD_REQUEST.value());
    }
}
