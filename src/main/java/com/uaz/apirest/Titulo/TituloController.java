package com.uaz.apirest.Titulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return alumnoRepository.findByMatricula(tituloRequest.getMatricula())
                .map(alumno -> {
                    TipoTitulacion tipoTitulacion = tipoTitulacionRepository.findByElementId(tituloRequest.getTipoTitulacionId())
                            .orElseThrow(() -> new RuntimeException("TipoTitulacion not found"));

                    Titulo titulo = new Titulo(alumno, tipoTitulacion, tituloRequest.getFechaTitulacion(), tituloRequest.getCedula());
                    Titulo savedTitulo = tituloRepository.save(titulo);
                    return ResponseEntity.ok(savedTitulo);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

class TituloRequest {
    private String matricula;
    private String tipoTitulacionId;
    private LocalDate fechaTitulacion;
    private int cedula;

    public String getMatricula() {
        return matricula;
    }
    public String getTipoTitulacionId() {
        return tipoTitulacionId;
    }
    public LocalDate getFechaTitulacion() {
        return fechaTitulacion;
    }
    public int getCedula() {
        return cedula;
    }

    
}
