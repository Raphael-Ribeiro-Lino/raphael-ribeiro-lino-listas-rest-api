package br.com.raphael.ribeiro.lino.listas.rest.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.repositories.ListaRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;

	public ListaEntity cadastra(ListaEntity listaEntity) {
		return listaRepository.save(listaEntity);
	}
}
