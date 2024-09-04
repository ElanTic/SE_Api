package com.uaz.apirest.Titulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-titulacion")
public class TipoTitulacionController {

    @Autowired
    private TipoTitulacionRepository tipoTitulacionRepository;

    @GetMapping
    public List<TipoTitulacion> getAllTiposTitulacion() {
        return tipoTitulacionRepository.findAll();
    }

    @GetMapping("/{elementId}")
    public ResponseEntity<TipoTitulacion> getTipoTitulacionById(@PathVariable String elementId) {
        return tipoTitulacionRepository.findByElementId(elementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoTitulacion createTipoTitulacion(@RequestBody TipoTitulacion tipoTitulacion) {
        return tipoTitulacionRepository.save(tipoTitulacion);
    }

    @PutMapping("/{elementId}")
    public ResponseEntity<TipoTitulacion> updateTipoTitulacion(@PathVariable String elementId, @RequestBody TipoTitulacion tipoTitulacionDetails) {
        return tipoTitulacionRepository.findByElementId(elementId)
                .map(tipoTitulacion -> {
                    tipoTitulacion.setTipo(tipoTitulacionDetails.getTipo());
                    TipoTitulacion updatedTipoTitulacion = tipoTitulacionRepository.save(tipoTitulacion);
                    return ResponseEntity.ok(updatedTipoTitulacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{elementId}")
    public ResponseEntity<Void> deleteTipoTitulacion(@PathVariable String elementId) {
        return tipoTitulacionRepository.findByElementId(elementId)
                .map(tipoTitulacion -> {
                    tipoTitulacionRepository.delete(tipoTitulacion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
