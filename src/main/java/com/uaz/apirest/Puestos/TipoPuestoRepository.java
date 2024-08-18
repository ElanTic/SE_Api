package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;

public interface TipoPuestoRepository extends Neo4jRepository<TipoPuesto, Long> {
    Optional<TipoPuesto> findByNombre(String nombre);
}