package com.unidade12.projetopi.repository;

import org.springframework.data.repository.CrudRepository;

import com.unidade12.projetopi.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

	Evento findByCodigo(long codigo);
}

