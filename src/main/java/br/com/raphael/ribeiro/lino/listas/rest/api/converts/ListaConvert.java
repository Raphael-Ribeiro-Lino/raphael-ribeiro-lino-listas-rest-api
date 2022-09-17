package br.com.raphael.ribeiro.lino.listas.rest.api.converts;

import java.util.List;
import java.util.stream.Collectors;

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

	public void copyInputToEntity(ListaInput listaInput, ListaEntity listaEncontrada) {
		modelMapper.map(listaInput, listaEncontrada);
	}
	
	public List<ListaOutput> listaEntityToListOutput(List<ListaEntity> listas){
		return listas.stream().map(lista -> this.entityToOutput(lista)).collect(Collectors.toList());
	}
}
