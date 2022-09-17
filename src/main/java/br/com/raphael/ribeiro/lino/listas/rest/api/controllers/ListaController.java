package br.com.raphael.ribeiro.lino.listas.rest.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ListaOutput cadastraLista(@RequestBody @Valid ListaInput listaInput) {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cadastra(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}
	
	@PutMapping("/{id}")
	public ListaOutput alteraLista(@RequestBody @Valid ListaInput listaInput, @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaPorId(id);
		listaConvert.copyInputToEntity(listaInput, listaEncontrada);
		ListaEntity listaAlterada = listaService.altera(listaEncontrada);
		return listaConvert.entityToOutput(listaAlterada);
	}
	
	@GetMapping
	public List<ListaOutput> listaListas(){
		List<ListaEntity> listas = listaService.listaTodas();
		return listaConvert.listaEntityToListOutput(listas);
	}
	
	@GetMapping("/{id}")
	public ListaOutput buscaListaPorId(@PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaPorId(id);
		return listaConvert.entityToOutput(listaEncontrada);
	}
	

}
