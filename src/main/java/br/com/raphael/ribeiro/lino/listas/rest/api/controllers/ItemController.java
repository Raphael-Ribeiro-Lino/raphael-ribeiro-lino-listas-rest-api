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
import br.com.raphael.ribeiro.lino.listas.rest.api.converts.ItemConvert;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.inputs.ItemInput;
import br.com.raphael.ribeiro.lino.listas.rest.api.dto.outputs.ItemOutput;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ItemEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.services.ItemService;
import br.com.raphael.ribeiro.lino.listas.rest.api.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item")
@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/itens")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private ListaService listaService;
	
	@Operation(summary = "Cadastra item", description = "Cadastra um novo item no sistema")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput cadastraItem(@Parameter(description = "Representação de um item") @RequestBody @Valid ItemInput itemInput) {
		ItemEntity itemEntity = itemConvert.inputToEntity(itemInput);
		convertListas(itemInput, itemEntity);
		ItemEntity itemCriado = itemService.cadastra(itemEntity);
		return itemConvert.entityToOutput(itemCriado);
	}
	
	@PutMapping("/{id}")
	public ItemOutput alteraItem(@RequestBody @Valid ItemInput itemInput, @PathVariable Long id) {
		ItemEntity itemEncontrado = itemService.buscaPorId(id);
		itemConvert.copyInputToEntity(itemInput, itemEncontrado);
		convertListas(itemInput, itemEncontrado);
		ItemEntity itemAlterado = itemService.altera(itemEncontrado);
		return itemConvert.entityToOutput(itemAlterado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable Long id) {
		ItemEntity itemEncontrado = itemService.buscaPorId(id);
		itemService.remove(itemEncontrado);
	}
	
	@PutMapping("/{id}/concluir")
	public ItemOutput concluiItem(@PathVariable Long id) {
		ItemEntity itemEncontrado = itemService.buscaPorId(id);
		ItemEntity itemConcluido = itemService.conclui(itemEncontrado);
		return itemConvert.entityToOutput(itemConcluido);
	}
	
	@PutMapping("/{id}/nao-concluir")
	public ItemOutput itemNaoConcluido(@PathVariable Long id) {
		ItemEntity itemEncontrado = itemService.buscaPorId(id);
		ItemEntity itemNaoConcluido = itemService.naoConcluido(itemEncontrado);
		return itemConvert.entityToOutput(itemNaoConcluido);
	}
	
	@GetMapping("/lista/{listaId}")
	public List<ItemOutput> listaItensPorIdLista(@PathVariable Long listaId){
		ListaEntity lista = listaService.buscaPorId(listaId);
		List<ItemEntity> listaItens = itemService.listaTodosPelaLista(lista);
		return itemConvert.listEntityToListOutput(listaItens);
	}
	
	private void convertListas(ItemInput itemInput, ItemEntity itemEntity) {
		itemEntity.setLista(listaService.buscaPorId(itemInput.getListaId()));
	}
}
