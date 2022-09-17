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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Lista")
@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/listas")
@CrossOrigin(origins = "*")
public class ListaController {

	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ListaConvert listaConvert;
	
	@Operation(summary = "Cadastra lista", description = "Cadastra uma nova lista no sistema")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput cadastraLista(@Parameter(description = "Representação de uma lista") @RequestBody @Valid ListaInput listaInput) {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cadastra(listaEntity);
		return listaConvert.entityToOutput(listaCriada);
	}
	
	@Operation(summary = "Altera lista", description = "Altera os dados da lista selecionada")
	@PutMapping("/{id}")
	public ListaOutput alteraLista(@Parameter(description = "Representação de uma lista") @RequestBody @Valid ListaInput listaInput
			, @Parameter(description = "Id da lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaPorId(id);
		listaConvert.copyInputToEntity(listaInput, listaEncontrada);
		ListaEntity listaAlterada = listaService.altera(listaEncontrada);
		return listaConvert.entityToOutput(listaAlterada);
	}
	
	@Operation(summary = "Lista as listas", description = "Lista todas as listas cadastradas no sistema")
	@GetMapping
	public List<ListaOutput> listaListas(){
		List<ListaEntity> listas = listaService.listaTodas();
		return listaConvert.listaEntityToListOutput(listas);
	}
	
	@Operation(summary = "Busca lista por Id", description = "Busca uma lista pelo seu id")
	@GetMapping("/{id}")
	public ListaOutput buscaListaPorId(@Parameter(description = "Id da lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaPorId(id);
		return listaConvert.entityToOutput(listaEncontrada);
	}
	
	@Operation(summary = "Exclui lista", description = "Exclui a lista selecionada do sistema")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeLivro(@Parameter(description = "Id da lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaPorId(id);
		listaService.remove(listaEncontrada);
	}
}
