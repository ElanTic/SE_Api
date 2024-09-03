package com.uaz.apirest.Puestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {

    @Autowired
    private PuestoRepository puestoRepository;

    @Autowired
    private TipoPuestoRepository tipoPuestoRepository;

    @GetMapping
    public List<Puesto> getAllPuestos() {
        return puestoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> getPuestoById(@PathVariable String id) {
        return puestoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Puesto> getPuestosBySalario(@RequestParam double salario) {
        return puestoRepository.findBySalarioGreaterThanEqual(salario);
    }

    @PostMapping
    public ResponseEntity<Puesto> createPuesto(@RequestBody Puesto puesto) {
        if (puesto.getTipo() == null || tipoPuestoRepository.findByElementId(puesto.getTipo().getId()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(puestoRepository.save(puesto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puesto> updatePuesto(@PathVariable String id, @RequestBody Puesto puestoDetails) {
        return puestoRepository.findById(id)
                .map(puesto -> {
                    puesto.setTipo(puestoDetails.getTipo());
                    puesto.setDesc(puestoDetails.getDesc());
                    puesto.setSalario(puestoDetails.getSalario());
                    Puesto updatedPuesto = puestoRepository.save(puesto);
                    return ResponseEntity.ok(updatedPuesto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuesto(@PathVariable String id) {
        return puestoRepository.findById(id)
                .map(puesto -> {
                    puestoRepository.delete(puesto);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}