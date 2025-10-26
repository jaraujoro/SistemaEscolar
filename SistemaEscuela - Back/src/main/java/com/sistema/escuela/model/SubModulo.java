package com.sistema.escuela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "sub_modulo", schema = "ADM")
public class SubModulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sub_modulo;
    private String nombre_sub_modulo;
    private int nivel_sub_modulo;
    private String url_sub_modulo;
    private int estado_sub_modulo;
    @CreationTimestamp
    private LocalDateTime fecha_creacion_sub_modulo;
    @UpdateTimestamp
    private LocalDateTime fecha_actualiza_sub_modulo;
    
    private Long usuario_registra_sub_modulo;
    private Long usuario_actualiza_sub_modulo;
    
    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    public Long getId_sub_modulo() {
        return id_sub_modulo;
    }

    public void setId_sub_modulo(Long id_sub_modulo) {
        this.id_sub_modulo = id_sub_modulo;
    }

    public String getNombre_sub_modulo() {
        return nombre_sub_modulo;
    }

    public void setNombre_sub_modulo(String nombre_sub_modulo) {
        this.nombre_sub_modulo = nombre_sub_modulo;
    }

    public int getNivel_sub_modulo() {
        return nivel_sub_modulo;
    }

    public void setNivel_sub_modulo(int nivel_sub_modulo) {
        this.nivel_sub_modulo = nivel_sub_modulo;
    }

    public String getUrl_sub_modulo() {
        return url_sub_modulo;
    }

    public void setUrl_sub_modulo(String url_sub_modulo) {
        this.url_sub_modulo = url_sub_modulo;
    }

    public int getEstado_sub_modulo() {
        return estado_sub_modulo;
    }

    public void setEstado_sub_modulo(int estado_sub_modulo) {
        this.estado_sub_modulo = estado_sub_modulo;
    }

    public LocalDateTime getFecha_creacion_sub_modulo() {
        return fecha_creacion_sub_modulo;
    }

    public void setFecha_creacion_sub_modulo(LocalDateTime fecha_creacion_sub_modulo) {
        this.fecha_creacion_sub_modulo = fecha_creacion_sub_modulo;
    }

    public LocalDateTime getFecha_actualiza_sub_modulo() {
        return fecha_actualiza_sub_modulo;
    }

    public void setFecha_actualiza_sub_modulo(LocalDateTime fecha_actualiza_sub_modulo) {
        this.fecha_actualiza_sub_modulo = fecha_actualiza_sub_modulo;
    }

    public Long getUsuario_registra_sub_modulo() {
        return usuario_registra_sub_modulo;
    }

    public void setUsuario_registra_sub_modulo(Long usuario_registra_sub_modulo) {
        this.usuario_registra_sub_modulo = usuario_registra_sub_modulo;
    }

    public Long getUsuario_actualiza_sub_modulo() {
        return usuario_actualiza_sub_modulo;
    }

    public void setUsuario_actualiza_sub_modulo(Long usuario_actualiza_sub_modulo) {
        this.usuario_actualiza_sub_modulo = usuario_actualiza_sub_modulo;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
