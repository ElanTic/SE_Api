package com.uaz.apirest.nodes.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uaz.apirest.nodes.Titulo.Titulo;
import com.uaz.apirest.nodes.Titulo.TituloRepository;

import java.util.List;


@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;
    private TituloRepository tituloRepository;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Alumno> getAlumnoByMatricula(@PathVariable int matricula) {
        return alumnoRepository.findByMatricula(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fragments")
    public String getAlumnos(Model model) {
        model.addAllAttributes(getAllAlumnos());
        return "fragments/alumnos";
    }
    

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    /*
     * 
     @PutMapping("/{id}")
     public ResponseEntity<Alumno> updateAlumno(@PathVariable int id, @RequestBody Alumno alumnoDetails) {
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
            */
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable int id, @RequestBody Alumno alumnoDetails) {
        return alumnoRepository.findByMatricula(id)
            .map(alumno -> {
                // Update Alumno details
                alumno.setNombres(alumnoDetails.getNombres());
                alumno.setApellido1(alumnoDetails.getApellido1());
                alumno.setApellido2(alumnoDetails.getApellido2());
                alumno.setFechaIngreso(alumnoDetails.getFechaIngreso());
                alumno.setFechaEgreso(alumnoDetails.getFechaEgreso());

                // Optionally update Titulo if it exists
                if (alumno.getTitulo() != null && alumnoDetails.getTitulo() != null) {
                    Titulo existingTitulo = alumno.getTitulo();
                    Titulo updatedTitulo = alumnoDetails.getTitulo();

                    existingTitulo.setFechaTitulacion(updatedTitulo.getFechaTitulacion());
                    existingTitulo.setCedula(updatedTitulo.getCedula());
                    existingTitulo.setTipoTitulacion(updatedTitulo.getTipoTitulacion());

                    tituloRepository.save(existingTitulo); // Save the updated Titulo
                }

                Alumno updatedAlumno = alumnoRepository.save(alumno);
                return ResponseEntity.ok(updatedAlumno);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable int id) {
        return alumnoRepository.findByMatricula(id)
                .map(alumno -> {
                    // Optionally handle deletion of the associated Titulo
                    if (alumno.getTitulo() != null) {
                        Titulo titulo = alumno.getTitulo();
                        tituloRepository.delete(titulo); // Delete the Titulo if required
                    }

                    alumnoRepository.delete(alumno);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
