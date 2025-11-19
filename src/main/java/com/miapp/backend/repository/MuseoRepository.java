package com.miapp.backend.repository;

import com.miapp.backend.entity.Museo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MuseoRepository extends JpaRepository<Museo, Integer> {
    List<Museo> findByNombreContainingIgnoreCase(String nombre);
}
