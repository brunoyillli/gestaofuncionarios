package io.github.brunoyillli.gestaofuncionarios.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.brunoyillli.gestaofuncionarios.entity.Funcionario;
import io.github.brunoyillli.gestaofuncionarios.exception.FuncionarioException;
import io.github.brunoyillli.gestaofuncionarios.repository.FuncionarioRepository;
import io.github.brunoyillli.gestaofuncionarios.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	@Transactional
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario findById(Integer id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new FuncionarioException("Funcionário não encontrado"));
	}

	@Override
	@Transactional
	public Funcionario update(Integer id, Funcionario funcionario) {
		Funcionario funcionarioEncontrado = this.findById(id);

		funcionarioEncontrado.setNome(funcionario.getNome());
		funcionarioEncontrado.setSalario(funcionario.getSalario());
		funcionarioEncontrado.setDesignacao(funcionario.getDesignacao());
		funcionarioEncontrado.setTelefone(funcionario.getTelefone());
		funcionarioEncontrado.setEndereco(funcionario.getEndereco());

		return funcionarioRepository.save(funcionarioEncontrado);
	}

	@Override
	@Transactional
	public void deletar(Integer id) {
		Funcionario funcionarioEncontrado = findById(id);
		funcionarioRepository.delete(funcionarioEncontrado);
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

}
