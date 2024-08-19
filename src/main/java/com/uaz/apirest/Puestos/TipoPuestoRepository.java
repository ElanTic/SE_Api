package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface TipoPuestoRepository extends Neo4jRepository<TipoPuesto, String> {
    @Query("MATCH (tipoPuesto:TipoPuesto) WHERE elementId(tipoPuesto) = $id RETURN tipoPuesto")
    Optional<TipoPuesto> findByElementId(String id);
    
    Optional<TipoPuesto> findByNombre(String nombre);
}