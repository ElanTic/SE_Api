package com.uaz.apirest.nodes.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface TipoPuestoRepository extends Neo4jRepository<TipoPuesto, Long> {
    Optional<TipoPuesto> findByElementId(Long elementId);
    
    //Optional<TipoPuesto> findByNombre(String nombre);
}