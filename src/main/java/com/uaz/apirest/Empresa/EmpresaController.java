package com.uaz.apirest.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{elementId}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable String elementId) {
        return empresaRepository.findByElementId(elementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Empresa> getEmpresaByNombre(@RequestParam String nombre) {
        return empresaRepository.findByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @PutMapping("/{elementId}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable String elementId, @RequestBody Empresa empresaDetails) {
        return empresaRepository.findByElementId(elementId)
                .map(empresa -> {
                    empresa.setNombre(empresaDetails.getNombre());
                    empresa.setRfc(empresaDetails.getRfc());
                    empresa.setDireccion(empresaDetails.getDireccion());
                    empresa.setTelefono(empresaDetails.getTelefono());
                    empresa.setEmail(empresaDetails.getEmail());
                    empresa.setTipoDeEmpresa(empresaDetails.getTipoDeEmpresa());
                    empresa.setRepresentanteLegal(empresaDetails.getRepresentanteLegal());
                    empresa.setWebsite(empresaDetails.getWebsite());
                    Empresa updatedEmpresa = empresaRepository.save(empresa);
                    return ResponseEntity.ok(updatedEmpresa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{elementId}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable String elementId) {
        return empresaRepository.findByElementId(elementId)
                .map(empresa -> {
                    empresaRepository.delete(empresa);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}