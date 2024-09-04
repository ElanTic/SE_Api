package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;
import java.util.Optional;

public interface PuestoRepository extends Neo4jRepository<Puesto, String> {
    List<Puesto> findBySalarioGreaterThanEqual(double salario);
    Optional<Puesto> findByElementId(String elementId);
}
