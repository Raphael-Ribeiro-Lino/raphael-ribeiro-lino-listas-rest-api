package br.com.raphael.ribeiro.lino.listas.rest.api.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.raphael.ribeiro.lino.listas.rest.api.dto.inputs.ListaInput;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.outputs.ListaOutput;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;

@Component
public class ListaConvert {

	@Autowired
	private ModelMapper modelMapper;

	public ListaEntity inputToEntity(ListaInput listaInput) {
		return modelMapper.map(listaInput, ListaEntity.class);
	}

	public ListaOutput entityToOutput(ListaEntity listaCriada) {
		return modelMapper.map(listaCriada, ListaOutput.class);
	}
}
