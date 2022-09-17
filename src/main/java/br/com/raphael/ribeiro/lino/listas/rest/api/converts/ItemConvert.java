package br.com.raphael.ribeiro.lino.listas.rest.api.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConvert {

	@Autowired
	private ModelMapper modelMapper;
}
