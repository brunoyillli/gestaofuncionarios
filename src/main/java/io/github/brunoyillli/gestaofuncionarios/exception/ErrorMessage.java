package io.github.brunoyillli.gestaofuncionarios.exception;

import java.util.List;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Hidden
public class ErrorMessage {

	private String message;
	private List<String> messageErros;
	private int statusCode;
	
	public ErrorMessage(List<String> messageErros, int statusCode) {
		this.messageErros = messageErros;
		this.statusCode = statusCode;
	}

	public ErrorMessage(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}
	
	
}
