package com.uaz.apirest.Titulo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TipoTitulacionRepository extends Neo4jRepository<TipoTitulacion, String> {
}