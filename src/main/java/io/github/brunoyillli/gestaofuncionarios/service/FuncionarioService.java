package io.github.brunoyillli.gestaofuncionarios.service;

import java.util.List;

import io.github.brunoyillli.gestaofuncionarios.entity.Funcionario;

public interface FuncionarioService {

	Funcionario save(Funcionario funcionario);

	Funcionario findById(Integer id);
	
	List<Funcionario> findAll();

	Funcionario update(Integer id, Funcionario funcionario);

	void delete(Integer id);
}
