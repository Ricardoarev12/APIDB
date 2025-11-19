package com.miapp.backend.service;

import com.miapp.backend.entity.Municipio;
import com.miapp.backend.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public List<Municipio> findAll() {
        return municipioRepository.findAll();
    }

    public Optional<Municipio> findById(Integer id) {
        return municipioRepository.findById(id);
    }

    public List<Municipio> findByEstadoId(Integer idEstado) {
        return municipioRepository.findByEstado_IdEstado(idEstado);
    }

    public Municipio save(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public void deleteById(Integer id) {
        municipioRepository.deleteById(id);
    }
}
