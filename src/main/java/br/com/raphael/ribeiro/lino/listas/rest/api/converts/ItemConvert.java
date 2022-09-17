package br.com.raphael.ribeiro.lino.listas.rest.api.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.raphael.ribeiro.lino.listas.rest.api.dto.inputs.ItemInput;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.outputs.ItemOutput;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ItemEntity;

@Component
public class ItemConvert {

	@Autowired
	private ModelMapper modelMapper;

	public ItemEntity inputToEntity(ItemInput itemInput) {
		return modelMapper.map(itemInput, ItemEntity.class);
	}

	public ItemOutput entityToOutput(ItemEntity itemCriado) {
		return modelMapper.map(itemCriado, ItemOutput.class);
	}

	public void copyInputToEntity(ItemInput itemInput, ItemEntity itemEncontrado) {
		modelMapper.map(itemInput, itemEncontrado);
	}
}
