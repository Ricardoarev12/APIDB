package com.miapp.backend.controller;

import com.miapp.backend.entity.Estado;
import com.miapp.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAll() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Integer id) {
        return estadoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        Estado saved = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Integer id, @RequestBody Estado estado) {
        if (!estadoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estado.setIdEstado(id);
        Estado updated = estadoService.save(estado);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!estadoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
