package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;

public interface PuestoRepository extends Neo4jRepository<Puesto, Long> {
    List<Puesto> findBySalarioGreaterThanEqual(double salario);
}
