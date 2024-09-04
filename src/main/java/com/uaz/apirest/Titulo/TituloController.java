package com.uaz.apirest.Titulo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uaz.apirest.Alumno.Alumno;
import com.uaz.apirest.Alumno.AlumnoRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/titulos")
public class TituloController {

    @Autowired
    private TituloRepository tituloRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private TipoTitulacionRepository tipoTitulacionRepository;

    @GetMapping
    public List<Titulo> getAllTitulos() {
        return tituloRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Titulo> createTitulo(@RequestBody TituloRequest tituloRequest) {
        Optional<Alumno> alumnoOpt = alumnoRepository.findByMatricula(tituloRequest.getMatricula());
        if (!alumnoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Alumno alumno = alumnoOpt.get();

        Optional<TipoTitulacion> tipoTitulacionOpt = tipoTitulacionRepository.findById(tituloRequest.getTipoTitulacionId());
        if (!tipoTitulacionOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        TipoTitulacion tipoTitulacion = tipoTitulacionOpt.get();

        Titulo titulo = new Titulo(alumno, tipoTitulacion, tituloRequest.getFechaTitulacion(), tituloRequest.getCedula());
        tituloRepository.save(titulo);

        return ResponseEntity.status(HttpStatus.CREATED).body(titulo);
}
}

class TituloRequest {
    private int matricula;
    private Long tipoTitulacionId;
    private LocalDate fechaTitulacion;
    private int cedula;

    public int getMatricula() {
        return matricula;
    }
    public Long getTipoTitulacionId() {
        return tipoTitulacionId;
    }
    public LocalDate getFechaTitulacion() {
        return fechaTitulacion;
    }
    public int getCedula() {
        return cedula;
    }

    
}
