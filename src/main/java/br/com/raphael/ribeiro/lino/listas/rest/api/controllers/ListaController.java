package br.com.raphael.ribeiro.lino.listas.rest.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphael.ribeiro.lino.listas.rest.api.configs.ControllerConfig;
import br.com.raphael.ribeiro.lino.listas.rest.api.converts.ListaConvert;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.inputs.ListaInput;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.outputs.ListaOutput;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.services.ListaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/listas")
@CrossOrigin(origins = "*")
public class ListaController {

	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ListaConvert listaConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput cadastra(@RequestBody @Valid ListaInput listaInput) {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cadastra(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}
}
