package com.uaz.apirest.gestor.loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uaz.apirest.nodes.Alumno.Alumno;
import com.uaz.apirest.nodes.Alumno.AlumnoRepository;

public class AlumnoLoader {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public void saveNodes(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            alumnoRepository.save(alumno);
        }
    }
}