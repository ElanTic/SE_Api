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

    @GetMapping("/{uuid}")
    public ResponseEntity<TipoTitulacion> getTipoTitulacionById(@PathVariable String uuid) {
        return tipoTitulacionRepository.findByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoTitulacion createTipoTitulacion(@RequestBody TipoTitulacion tipoTitulacion) {
        return tipoTitulacionRepository.save(tipoTitulacion);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<TipoTitulacion> updateTipoTitulacion(@PathVariable String uuid, @RequestBody TipoTitulacion tipoTitulacionDetails) {
        return tipoTitulacionRepository.findByUuid(uuid)
                .map(tipoTitulacion -> {
                    tipoTitulacion.setTipo(tipoTitulacionDetails.getTipo());
                    TipoTitulacion updatedTipoTitulacion = tipoTitulacionRepository.save(tipoTitulacion);
                    return ResponseEntity.ok(updatedTipoTitulacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteTipoTitulacion(@PathVariable String uuid) {
        return tipoTitulacionRepository.findByUuid(uuid)
                .map(tipoTitulacion -> {
                    tipoTitulacionRepository.delete(tipoTitulacion);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
