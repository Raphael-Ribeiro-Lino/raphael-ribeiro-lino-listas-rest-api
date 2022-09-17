package br.com.raphael.ribeiro.lino.listas.rest.api.dto.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	
	private String titulo;
	
	private Boolean concluido;
	
	private ListaOutput lista;
}
