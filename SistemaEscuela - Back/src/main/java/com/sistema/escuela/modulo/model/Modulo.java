package com.sistema.escuela.modulo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "modulo", schema = "ADM")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modulo;
    private String nombre_modulo;
    private int nivel_modulo;
    private String url_modulo;
    private String icono_modulo;
    private int estado_modulo;
 
    @CreationTimestamp
    private LocalDateTime fecha_creacion_modulo;
    @UpdateTimestamp
    private LocalDateTime fecha_actualiza_modulo;
    
    private Long usuario_registra_modulo;
    private Long usuario_actualiza_modulo;
}
