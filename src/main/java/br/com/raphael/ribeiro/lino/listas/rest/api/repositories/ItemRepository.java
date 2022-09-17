package br.com.raphael.ribeiro.lino.listas.rest.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ItemEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	List<ItemEntity> findAllByLista(ListaEntity lista);

}
