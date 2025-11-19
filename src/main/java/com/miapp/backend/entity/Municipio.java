package com.miapp.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmunicipio")
    private Integer idMunicipio;

    @Column(name = "nombremunicipio", nullable = false, length = 200)
    private String nombreMunicipio;

    @ManyToOne
    @JoinColumn(name = "idestado", nullable = false)
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "municipio")
    private List<Museo> museos;

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Museo> getMuseos() {
        return museos;
    }

    public void setMuseos(List<Museo> museos) {
        this.museos = museos;
    }
}
