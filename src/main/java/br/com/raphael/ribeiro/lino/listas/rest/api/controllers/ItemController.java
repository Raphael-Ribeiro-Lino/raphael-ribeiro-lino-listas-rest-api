package br.com.raphael.ribeiro.lino.listas.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphael.ribeiro.lino.listas.rest.api.configs.ControllerConfig;
import br.com.raphael.ribeiro.lino.listas.rest.api.converts.ItemConvert;
import br.com.raphael.ribeiro.lino.listas.rest.api.services.ItemService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/itens")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert; 
}
