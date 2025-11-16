
package com.sistema.escuela.subModulo.dto;

public class SubModuloRequestDto {
    private String where;
    private String id_sub_modulo;

    public void setId_sub_modulo(String id_sub_modulo){
        this.id_sub_modulo = id_sub_modulo;
    }
    public String getId_sub_modulo(){
        return id_sub_modulo;
    }

    public void setWhere(String where){
        this.where = where;
    }
    public String getWhere(){
        return where;
    }
}
