package com.miapp.backend.repository;

import com.miapp.backend.entity.TipoMuseo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMuseoRepository extends JpaRepository<TipoMuseo, Integer> {
}
