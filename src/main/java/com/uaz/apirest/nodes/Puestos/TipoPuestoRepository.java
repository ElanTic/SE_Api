package com.uaz.apirest.nodes.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface TipoPuestoRepository extends Neo4jRepository<TipoPuesto, String> {
    Optional<TipoPuesto> findByElementId(String elementId);
    Optional<TipoPuesto> findByNombre(String nombre);
}