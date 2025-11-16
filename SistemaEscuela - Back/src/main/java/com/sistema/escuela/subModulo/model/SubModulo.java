package com.sistema.escuela.subModulo.model;

import com.sistema.escuela.modulo.model.Modulo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

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
    private LocalDateTime fecha_creacion_sub_modulo;
    private LocalDateTime fecha_actualiza_sub_modulo;
    private Long usuario_registra_sub_modulo;
    private Long usuario_actualiza_sub_modulo;
    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;
}
