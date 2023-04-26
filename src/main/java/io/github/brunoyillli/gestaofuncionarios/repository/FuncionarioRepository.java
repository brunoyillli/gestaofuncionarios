package io.github.brunoyillli.gestaofuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.gestaofuncionarios.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
