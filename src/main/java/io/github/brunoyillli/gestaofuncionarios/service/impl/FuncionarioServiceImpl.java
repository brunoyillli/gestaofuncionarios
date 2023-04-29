package io.github.brunoyillli.gestaofuncionarios.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.github.brunoyillli.gestaofuncionarios.entity.Funcionario;
import io.github.brunoyillli.gestaofuncionarios.exception.FuncionarioException;
import io.github.brunoyillli.gestaofuncionarios.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private Map<Integer, Funcionario> funcionarios;

	public FuncionarioServiceImpl() {
		this.funcionarios = new HashMap<>();
	}

	@Override
	public Funcionario save(Funcionario funcionario) {
		if (funcionario == null) {
			throw new IllegalArgumentException("Funcionário não pode ser nulo");
		}
		Integer id = getNextId();
		funcionario.setId(id);
		funcionarios.put(id, funcionario);
		return funcionario;
	}

	@Override
	public Funcionario findById(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("ID não pode ser nulo");
		}
		Funcionario funcionarioEncontrado = funcionarios.get(id);
		if (funcionarioEncontrado == null) {
			throw new FuncionarioException("Funcionário não encontrado");
		}
		return funcionarioEncontrado;
	}

	@Override
	public Funcionario update(Integer id, Funcionario funcionario) {
		if (id == null) {
			throw new IllegalArgumentException("ID não pode ser nulo");
		}
		if (funcionario == null) {
			throw new IllegalArgumentException("Funcionário não pode ser nulo");
		}
		Funcionario funcionarioEncontrado = findById(id);
		funcionarioEncontrado.setNome(funcionario.getNome());
		funcionarioEncontrado.setSalario(funcionario.getSalario());
		funcionarioEncontrado.setDesignacao(funcionario.getDesignacao());
		funcionarioEncontrado.setTelefone(funcionario.getTelefone());
		funcionarioEncontrado.setEndereco(funcionario.getEndereco());
		return funcionarioEncontrado;
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("ID não pode ser nulo");
		}
		Funcionario funcionarioEncontrado = findById(id);
		funcionarios.remove(funcionarioEncontrado.getId());
	}

	@Override
	public List<Funcionario> findAll() {
		return new ArrayList<>(funcionarios.values());
	}

	private Integer getNextId() {
		return funcionarios.keySet().stream().max(Integer::compare).orElse(0) + 1;
	}
}
