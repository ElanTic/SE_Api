package com.uaz.apirest.nodes.Titulo;

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

    @GetMapping("/{id}")
    public ResponseEntity<TipoTitulacion> getTipoTitulacionById(@PathVariable Long id) {
        return tipoTitulacionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoTitulacion createTipoTitulacion(@RequestBody TipoTitulacion tipoTitulacion) {
        return tipoTitulacionRepository.save(tipoTitulacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTitulacion> updateTipoTitulacion(@PathVariable Long id, @RequestBody TipoTitulacion tipoTitulacionDetails) {
        return tipoTitulacionRepository.findById(id)
                .map(tipoTitulacion -> {
                    tipoTitulacion.setTipo(tipoTitulacionDetails.getTipo());
                    TipoTitulacion updatedTipoTitulacion = tipoTitulacionRepository.save(tipoTitulacion);
                    return ResponseEntity.ok(updatedTipoTitulacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoTitulacion(@PathVariable Long id) {
        return tipoTitulacionRepository.findById(id)
                .map(tipoTitulacion -> {
                    tipoTitulacionRepository.delete(tipoTitulacion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
