/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.escuela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

/**
 *
 * @author PC
 */
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modulo;
    private String nombre_modulo;
    private String nivel_modulo;
    private String url_modulo;
    private String icono_modulo;
    private String estado_modulo;
    private Date fecha_creacion_modulo;
    private Date fecha_actualiza_modulo;
    private Long usuario_registra_modulo;
    private Long usuario_actualiza_modulo;

    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public String getNivel_modulo() {
        return nivel_modulo;
    }

    public void setNivel_modulo(String nivel_modulo) {
        this.nivel_modulo = nivel_modulo;
    }

    public String getUrl_modulo() {
        return url_modulo;
    }

    public void setUrl_modulo(String url_modulo) {
        this.url_modulo = url_modulo;
    }

    public String getIcono_modulo() {
        return icono_modulo;
    }

    public void setIcono_modulo(String icono_modulo) {
        this.icono_modulo = icono_modulo;
    }

    public String getEstado_modulo() {
        return estado_modulo;
    }

    public void setEstado_modulo(String estado_modulo) {
        this.estado_modulo = estado_modulo;
    }

    public Date getFecha_creacion_modulo() {
        return fecha_creacion_modulo;
    }

    public void setFecha_creacion_modulo(Date fecha_creacion_modulo) {
        this.fecha_creacion_modulo = fecha_creacion_modulo;
    }

    public Date getFecha_actualiza_modulo() {
        return fecha_actualiza_modulo;
    }

    public void setFecha_actualiza_modulo(Date fecha_actualiza_modulo) {
        this.fecha_actualiza_modulo = fecha_actualiza_modulo;
    }

    public Long getUsuario_registra_modulo() {
        return usuario_registra_modulo;
    }

    public void setUsuario_registra_modulo(Long usuario_registra_modulo) {
        this.usuario_registra_modulo = usuario_registra_modulo;
    }

    public Long getUsuario_actualiza_modulo() {
        return usuario_actualiza_modulo;
    }

    public void setUsuario_actualiza_modulo(Long usuario_actualiza_modulo) {
        this.usuario_actualiza_modulo = usuario_actualiza_modulo;
    }

    
    
}
