package br.com.raphael.ribeiro.lino.listas.rest.api.dto.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaInput {

	@NotBlank(message = "O título é obrigatório")
	@Length(min = 1, max = 100, message = "O títlo pode ter no máximo 100 caracteres")
	private String titulo;
}
