package com.miapp.backend.controller;

import com.miapp.backend.entity.Museo;
import com.miapp.backend.service.MuseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/museos")
public class MuseoController {

    @Autowired
    private MuseoService museoService;

    @GetMapping
    public List<Museo> getAll(@RequestParam(required = false) String nombre) {
        return museoService.findByNombre(nombre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Museo> getById(@PathVariable Integer id) {
        return museoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Museo> create(@RequestBody Museo museo) {
        Museo saved = museoService.save(museo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Museo> update(@PathVariable Integer id, @RequestBody Museo museo) {
        if (!museoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        museo.setIdMuseo(id);
        Museo updated = museoService.save(museo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!museoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        museoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
