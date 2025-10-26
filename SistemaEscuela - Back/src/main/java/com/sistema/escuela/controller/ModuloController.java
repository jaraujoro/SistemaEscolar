package com.sistema.escuela.controller;

import com.sistema.escuela.dto.modulo.ModuloRequestDto;
import com.sistema.escuela.service.ModuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.escuela.dto.modulo.ModuloResponseDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/modulo-controller")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @PostMapping("/listado-modulo")
    public ResponseEntity<?> listarModuloController(@RequestBody ModuloRequestDto moduloRequestDto) {
        try {
            List<ModuloResponseDto> modulos = moduloService.listModuloService(moduloRequestDto);
            return ResponseEntity.ok(modulos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar el módulo: " + e.getMessage());
        }
    }

    @PostMapping("/guardar-modulo")
    public ResponseEntity<?> guardarModuloController(@RequestBody ModuloRequestDto moduloRequestDto) {
        try {
            ModuloResponseDto moduloGuardado = moduloService.guardarModuloService(moduloRequestDto);
            return ResponseEntity.ok(moduloGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el módulo: " + e.getMessage());
        }
    }

    @PostMapping("/editar-modulo")
    public ResponseEntity<?> editarModuloController(@RequestBody ModuloRequestDto moduloRequestDto) {
        try {
            ModuloResponseDto moduloEditar = moduloService.editarModuloService(moduloRequestDto);
            return ResponseEntity.ok(moduloEditar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al editar el registro: " + e.getMessage());
        }
    }

    @PostMapping("/eliminar-modulo")
    public ResponseEntity<?> eliminarModuloController(@RequestBody String id) {
        try {
            ModuloResponseDto moduloEliminar = moduloService.eliminarModuloService(id);
            return ResponseEntity.ok(moduloEliminar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el registro: " + e.getMessage());
        }
    }
}
