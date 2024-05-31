package com.uaz.apirest.Titulo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TituloRepository extends Neo4jRepository<Titulo, Integer> {
}
