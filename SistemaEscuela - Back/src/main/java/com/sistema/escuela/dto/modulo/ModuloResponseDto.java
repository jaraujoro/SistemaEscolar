package com.sistema.escuela.dto.modulo;

import java.util.Date;

public class ModuloResponseDto {

    private String id_modulo;
    private String estado_modulo;
    private String fecha_actualiza_modulo;
    private String fecha_creacion_modulo;
    private String icono_modulo;
    private String nivel_modulo;
    private String nombre_modulo;
    private String url_modulo;
    private String o_nres;
    private String o_msj;

    // Constructor vacío
    public ModuloResponseDto() {
    }

    public String getO_nres() {
        return o_nres;
    }

    public void setO_nres(String o_nres) {
        this.o_nres = o_nres;
    }

    public String getO_msj() {
        return o_msj;
    }

    public void setO_msj(String o_msj) {
        this.o_msj = o_msj;
    }

    // Getters y setters
    public String getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(String id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getEstado_modulo() {
        return estado_modulo;
    }

    public void setEstado_modulo(String estado_modulo) {
        this.estado_modulo = estado_modulo;
    }

    public String getFecha_actualiza_modulo() {
        return fecha_actualiza_modulo;
    }

    public void setFecha_actualiza_modulo(String fecha_actualiza_modulo) {
        this.fecha_actualiza_modulo = fecha_actualiza_modulo;
    }

    public String getFecha_creacion_modulo() {
        return fecha_creacion_modulo;
    }

    public void setFecha_creacion_modulo(String fecha_creacion_modulo) {
        this.fecha_creacion_modulo = fecha_creacion_modulo;
    }

    public String getIcono_modulo() {
        return icono_modulo;
    }

    public void setIcono_modulo(String icono_modulo) {
        this.icono_modulo = icono_modulo;
    }

    public String getNivel_modulo() {
        return nivel_modulo;
    }

    public void setNivel_modulo(String nivel_modulo) {
        this.nivel_modulo = nivel_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public String getUrl_modulo() {
        return url_modulo;
    }

    public void setUrl_modulo(String url_modulo) {
        this.url_modulo = url_modulo;
    }
}
