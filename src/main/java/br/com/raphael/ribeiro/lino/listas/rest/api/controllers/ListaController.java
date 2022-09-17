package br.com.raphael.ribeiro.lino.listas.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphael.ribeiro.lino.listas.rest.api.configs.ControllerConfig;
import br.com.raphael.ribeiro.lino.listas.rest.api.converts.ListaConvert;
import br.com.raphael.ribeiro.lino.listas.rest.api.services.ListaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/listas")
@CrossOrigin(origins = "*")
public class ListaController {

	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ListaConvert listaConvert;
}
