package com.miapp.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tipomuseo")
public class TipoMuseo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipomuseo")
    private Integer idTipoMuseo;

    @Column(name = "nombretipo", nullable = false, length = 200)
    private String nombreTipo;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoMuseo")
    private List<Museo> museos;

    public Integer getIdTipoMuseo() {
        return idTipoMuseo;
    }

    public void setIdTipoMuseo(Integer idTipoMuseo) {
        this.idTipoMuseo = idTipoMuseo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public List<Museo> getMuseos() {
        return museos;
    }

    public void setMuseos(List<Museo> museos) {
        this.museos = museos;
    }
}
