package com.uaz.apirest.Alumno;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;

public interface AlumnoRepository extends Neo4jRepository<Alumno, String> {
    Optional<Alumno> findByMatricula(String matricula);
}