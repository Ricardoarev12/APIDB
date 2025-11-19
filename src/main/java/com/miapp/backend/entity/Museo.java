package com.miapp.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "museo")
public class Museo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmuseo")
    private Integer idMuseo;

    @Column(name = "nombre", nullable = false, length = 300)
    private String nombre;

    @Column(name = "direccion", length = 500)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idmunicipio", nullable = false)
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "idtipomuseo", nullable = false)
    private TipoMuseo tipoMuseo;

    @Column(name = "codigopostal", length = 10)
    private String codigoPostal;

    @Column(name = "telefono", length = 60)
    private String telefono;

    @Column(name = "horario", length = 200)
    private String horario;

    public Integer getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(Integer idMuseo) {
        this.idMuseo = idMuseo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoMuseo getTipoMuseo() {
        return tipoMuseo;
    }

    public void setTipoMuseo(TipoMuseo tipoMuseo) {
        this.tipoMuseo = tipoMuseo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
