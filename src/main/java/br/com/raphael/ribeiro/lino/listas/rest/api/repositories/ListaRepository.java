package br.com.raphael.ribeiro.lino.listas.rest.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raphael.ribeiro.lino.listas.rest.api.entities.ListaEntity;

public interface ListaRepository extends JpaRepository<ListaEntity, Long>{

}
