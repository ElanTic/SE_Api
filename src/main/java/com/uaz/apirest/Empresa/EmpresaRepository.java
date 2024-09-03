package com.uaz.apirest.Empresa;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;

public interface EmpresaRepository extends Neo4jRepository<Empresa, String> {
    Optional<Empresa> findByNombre(String nombre);
}