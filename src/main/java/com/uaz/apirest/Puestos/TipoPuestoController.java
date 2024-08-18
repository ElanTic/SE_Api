package com.uaz.apirest.Puestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposPuesto")
public class TipoPuestoController {

    @Autowired
    private TipoPuestoRepository tipoPuestoRepository;

    @GetMapping
    public List<TipoPuesto> getAllTiposPuesto() {
        return tipoPuestoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPuesto> getTipoPuestoById(@PathVariable Long id) {
        return tipoPuestoRepository.findById(id)
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

    @PutMapping("/{id}")
    public ResponseEntity<TipoPuesto> updateTipoPuesto(@PathVariable Long id, @RequestBody TipoPuesto tipoPuestoDetails) {
        return tipoPuestoRepository.findById(id)
                .map(tipoPuesto -> {
                    tipoPuesto.setNombre(tipoPuestoDetails.getNombre());
                    TipoPuesto updatedTipoPuesto = tipoPuestoRepository.save(tipoPuesto);
                    return ResponseEntity.ok(updatedTipoPuesto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPuesto(@PathVariable Long id) {
        return tipoPuestoRepository.findById(id)
                .map(tipoPuesto -> {
                    tipoPuestoRepository.delete(tipoPuesto);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}