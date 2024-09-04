package com.uaz.apirest.Puestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-puesto")
public class TipoPuestoController {

    @Autowired
    private TipoPuestoRepository tipoPuestoRepository;

    @GetMapping
    public List<TipoPuesto> getAllTiposPuesto() {
        return tipoPuestoRepository.findAll();
    }

    @GetMapping("/{elementId}")
    public ResponseEntity<TipoPuesto> getTipoPuestoById(@PathVariable String elementId) {
        return tipoPuestoRepository.findByElementId(elementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<TipoPuesto> getTipoPuestoByNombre(@RequestParam String nombre) {
        return tipoPuestoRepository.findByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoPuesto createTipoPuesto(@RequestBody TipoPuesto tipoPuesto) {
        return tipoPuestoRepository.save(tipoPuesto);
    }

    @PutMapping("/{elementId}")
    public ResponseEntity<TipoPuesto> updateTipoPuesto(@PathVariable String elementId, @RequestBody TipoPuesto tipoPuestoDetails) {
        return tipoPuestoRepository.findByElementId(elementId)
                .map(tipoPuesto -> {
                    tipoPuesto.setNombre(tipoPuestoDetails.getNombre());
                    TipoPuesto updatedTipoPuesto = tipoPuestoRepository.save(tipoPuesto);
                    return ResponseEntity.ok(updatedTipoPuesto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{elementId}")
    public ResponseEntity<Void> deleteTipoPuesto(@PathVariable String elementId) {
        return tipoPuestoRepository.findByElementId(elementId)
                .map(tipoPuesto -> {
                    tipoPuestoRepository.delete(tipoPuesto);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}