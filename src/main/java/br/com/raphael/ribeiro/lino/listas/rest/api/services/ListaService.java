package br.com.raphael.ribeiro.lino.listas.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;
import br.com.raphael.ribeiro.lino.listas.rest.api.exceptions.NotFoundBussinessException;
import br.com.raphael.ribeiro.lino.listas.rest.api.repositories.ListaRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;

	public ListaEntity cadastra(ListaEntity listaEntity) {
		return listaRepository.save(listaEntity);
	}

	public ListaEntity buscaPorId(Long id) {
		return listaRepository.findById(id).orElseThrow(()-> new NotFoundBussinessException("Lista não encontrada"));
	}

	public ListaEntity altera(ListaEntity listaEncontrada) {
		return listaRepository.save(listaEncontrada);
	}

	public List<ListaEntity> listaTodas() {
		return listaRepository.findAll();
	}

	
}
