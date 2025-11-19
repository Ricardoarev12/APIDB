package com.miapp.backend.service;

import com.miapp.backend.entity.TipoMuseo;
import com.miapp.backend.repository.TipoMuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoMuseoService {

    @Autowired
    private TipoMuseoRepository tipoMuseoRepository;

    public List<TipoMuseo> findAll() {
        return tipoMuseoRepository.findAll();
    }

    public Optional<TipoMuseo> findById(Integer id) {
        return tipoMuseoRepository.findById(id);
    }

    public TipoMuseo save(TipoMuseo tipoMuseo) {
        return tipoMuseoRepository.save(tipoMuseo);
    }

    public void deleteById(Integer id) {
        tipoMuseoRepository.deleteById(id);
    }
}
