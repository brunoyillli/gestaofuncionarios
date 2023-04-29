package io.github.brunoyillli.gestaofuncionarios.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunoyillli.gestaofuncionarios.entity.Funcionario;
import io.github.brunoyillli.gestaofuncionarios.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
@Tag(name = "Funcionários", description = "API de gerenciamento de funcionários")
public class FuncionarioResource {

	private FuncionarioService funcionarioService;

	public FuncionarioResource(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
    @Operation(summary = "Adicionar um novo funcionário")
	public ResponseEntity<Funcionario> save(@RequestBody @Valid Funcionario funcionario) {
		funcionario = funcionarioService.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
	}
	
	@GetMapping
	@Operation(summary = "Obter detalhes dos funcionários existentes")
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> funcionarios = funcionarioService.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}

	@GetMapping("{id}")
	@Operation(summary = "Obter detalhes do funcionário existente")
	public ResponseEntity<Funcionario> datails(@PathVariable Integer id) {
		Funcionario funcionario = funcionarioService.findById(id);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

	@PutMapping("{id}")
	@Operation(summary = "Atualizar detalhes do funcionário existente")
	public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody @Valid Funcionario funcionario) {
		Funcionario funcionarioAtualizado = funcionarioService.update(id, funcionario);
		return new ResponseEntity<Funcionario>(funcionarioAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	@Operation(summary = "Excluir funcionário existente")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
