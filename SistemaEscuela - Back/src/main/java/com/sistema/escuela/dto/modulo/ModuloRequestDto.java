package com.sistema.escuela.dto.modulo;

public class ModuloRequestDto {

    private String id_modulo;
    private String nombre_modulo;
    private String nivel_modulo;
    private String url_modulo;
    private String icono_modulo;
    private String estado_modulo;
    private String id_usuario;
    private String where;

    public void setWhere(String where){
        this.where = where;
    }

    public String getWhere(){
        return where;
    }

    public String getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(String id_modulo) {
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

    public String getId_usuario(){
        return this.id_usuario;
    }
    public void setId_usuario(String id_usuario){
        this.id_usuario = id_usuario;
    }
}
