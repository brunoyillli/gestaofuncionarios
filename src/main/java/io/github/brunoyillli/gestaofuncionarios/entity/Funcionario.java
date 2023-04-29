package io.github.brunoyillli.gestaofuncionarios.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Entidade que representa um funcionário")
public class Funcionario {

	
    @Schema(description = "ID do funcionário")
	private Integer id;

	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 50, message = "O nome deve ter no máximo 100 caracteres")
	@Schema(description = "Nome do funcionário")
	private String nome;

	@NotBlank(message = "A designação é obrigatória")
	@Size(max = 30, message = "A designação deve ter no máximo 100 caracteres")
	@Schema(description = "Designação do funcionário")
	private String designacao;

	@NotNull(message = "O salário é obrigatório")
	@DecimalMin(value = "0.01", message = "O salário deve ser maior que zero")
	@Digits(integer = 6, fraction = 2, message = "O salário deve ter no máximo 6 dígitos inteiros e 2 dígitos decimais")
	@Schema(description = "Salário do funcionário")
	private BigDecimal salario;

	@NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}", message = "O telefone deve estar no formato (99) 9999-9999 ou (99) 99999-9999")
	@Schema(description = "Telefone do funcionário")
	private String telefone;

	@NotBlank(message = "O endereço é obrigatório")
    @Size(max = 200, message = "O endereço deve ter no máximo 200 caracteres")
	@Schema(description = "Endereço do funcionário")
	private String endereco;

}
