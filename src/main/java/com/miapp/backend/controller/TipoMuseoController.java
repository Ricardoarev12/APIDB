package com.miapp.backend.controller;

import com.miapp.backend.entity.TipoMuseo;
import com.miapp.backend.service.TipoMuseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipos-museo")
public class TipoMuseoController {

    @Autowired
    private TipoMuseoService tipoMuseoService;

    @GetMapping
    public List<TipoMuseo> getAll() {
        return tipoMuseoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMuseo> getById(@PathVariable Integer id) {
        return tipoMuseoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoMuseo> create(@RequestBody TipoMuseo tipoMuseo) {
        TipoMuseo saved = tipoMuseoService.save(tipoMuseo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMuseo> update(@PathVariable Integer id, @RequestBody TipoMuseo tipoMuseo) {
        if (!tipoMuseoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        tipoMuseo.setIdTipoMuseo(id);
        TipoMuseo updated = tipoMuseoService.save(tipoMuseo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!tipoMuseoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        tipoMuseoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
