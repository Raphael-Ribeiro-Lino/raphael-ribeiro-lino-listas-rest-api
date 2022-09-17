package br.com.raphael.ribeiro.lino.listas.rest.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ItemEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.exceptions.NotFoundBussinessException;
import br.com.raphael.ribeiro.lino.listas.rest.api.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity cadastra(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public ItemEntity buscaPorId(Long id) {
		return itemRepository.findById(id).orElseThrow(()-> new NotFoundBussinessException("Item não encontrado"));
	}

	public ItemEntity altera(ItemEntity itemEncontrado) {
		return itemRepository.save(itemEncontrado);
	}

	public void remove(ItemEntity itemEncontrado) {
		itemRepository.delete(itemEncontrado);
	}

	public ItemEntity conclui(ItemEntity itemEncontrado) {
		itemEncontrado.setConcluido(true);
		return itemRepository.save(itemEncontrado);
	}

	public ItemEntity naoConcluido(ItemEntity itemEncontrado) {
		itemEncontrado.setConcluido(false);
		return itemRepository.save(itemEncontrado);
	}
}
