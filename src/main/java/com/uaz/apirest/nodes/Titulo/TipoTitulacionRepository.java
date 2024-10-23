package com.uaz.apirest.nodes.Titulo;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TipoTitulacionRepository extends Neo4jRepository<TipoTitulacion, String> {
    Optional<TipoTitulacion> findByElementId(String elementId);
}