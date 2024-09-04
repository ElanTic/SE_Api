package com.uaz.apirest.Titulo;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TipoTitulacionRepository extends Neo4jRepository<TipoTitulacion, Long> {
    Optional<TipoTitulacion> findByElementId(Long elementId);
}