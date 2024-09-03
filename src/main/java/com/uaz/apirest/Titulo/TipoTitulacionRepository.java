package com.uaz.apirest.Titulo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;

public interface TipoTitulacionRepository extends Neo4jRepository<TipoTitulacion, String> {
    Optional<TipoTitulacion> findByUuid(String id);
}