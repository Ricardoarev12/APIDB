package com.miapp.backend.service;

import com.miapp.backend.entity.Museo;
import com.miapp.backend.repository.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MuseoService {

    @Autowired
    private MuseoRepository museoRepository;

    public List<Museo> findAll() {
        return museoRepository.findAll();
    }

    public Optional<Museo> findById(Integer id) {
        return museoRepository.findById(id);
    }

    public List<Museo> findByNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return museoRepository.findAll();
        }
        return museoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Museo save(Museo museo) {
        return museoRepository.save(museo);
    }

    public void deleteById(Integer id) {
        museoRepository.deleteById(id);
    }
}
