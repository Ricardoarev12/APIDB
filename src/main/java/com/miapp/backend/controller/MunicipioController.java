package com.miapp.backend.controller;

import com.miapp.backend.entity.Municipio;
import com.miapp.backend.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping
    public List<Municipio> getAll() {
        return municipioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> getById(@PathVariable Integer id) {
        return municipioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{idEstado}")
    public List<Municipio> getByEstado(@PathVariable Integer idEstado) {
        return municipioService.findByEstadoId(idEstado);
    }

    @PostMapping
    public ResponseEntity<Municipio> create(@RequestBody Municipio municipio) {
        Municipio saved = municipioService.save(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> update(@PathVariable Integer id, @RequestBody Municipio municipio) {
        if (!municipioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        municipio.setIdMunicipio(id);
        Municipio updated = municipioService.save(municipio);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!municipioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        municipioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
