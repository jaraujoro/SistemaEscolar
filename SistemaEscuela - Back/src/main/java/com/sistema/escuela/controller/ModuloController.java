package com.sistema.escuela.controller;

import com.sistema.escuela.model.Modulo;
import com.sistema.escuela.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("modulo-controller")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @PostMapping("/guardar-modulo")
    public ResponseEntity<?> guardarModuloController(@RequestBody Modulo modulo) {
        try {
            Modulo moduloGuardado = moduloService.guardarModuloService(modulo);
            return ResponseEntity.status(HttpStatus.CREATED).body(moduloGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el módulo: " + e.getMessage());
        }
    }

}
