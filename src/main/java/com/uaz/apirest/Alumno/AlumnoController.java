package com.uaz.apirest.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Alumno> getAlumnoByMatricula(@PathVariable String matricula) {
        return alumnoRepository.findByMatricula(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable String id, @RequestBody Alumno alumnoDetails) {
        return alumnoRepository.findByMatricula(id)
                .map(alumno -> {
                    alumno.setNombres(alumnoDetails.getNombres());
                    alumno.setApellido1(alumnoDetails.getApellido1());
                    alumno.setApellido2(alumnoDetails.getApellido2());
                    alumno.setFechaIngreso(alumnoDetails.getFechaIngreso());
                    alumno.setFechaEgreso(alumnoDetails.getFechaEgreso());
                    Alumno updatedAlumno = alumnoRepository.save(alumno);
                    return ResponseEntity.ok(updatedAlumno);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable String id) {
        return alumnoRepository.findByMatricula(id)
                .map(alumno -> {
                    alumnoRepository.delete(alumno);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
