package com.sistema.escuela.subModulo.controller;

import com.sistema.escuela.modulo.dto.ModuloResponseDto;
import com.sistema.escuela.subModulo.dto.SubModuloRequestDto;
import com.sistema.escuela.subModulo.dto.SubModuloResponseDto;
import com.sistema.escuela.subModulo.service.SubModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sub-modulo-controller")

public class SubModuloController {

    @Autowired
    private SubModuloService subModuloService;

    @PostMapping("/listado-sub-modulo")
    public ResponseEntity<List<SubModuloResponseDto>> listSubModuloController(@RequestBody SubModuloRequestDto subModuloRequestDto){
        try{
            List<SubModuloResponseDto> moduloResponseDtoList = subModuloService.listSubModuloService(subModuloRequestDto);
            return ResponseEntity.ok(moduloResponseDtoList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/eliminar-sub-modulo")
    public ResponseEntity<SubModuloResponseDto> elimiarSubModuloController(@RequestBody SubModuloRequestDto subModuloRequestDto){
        try {
            SubModuloResponseDto result = subModuloService.eliminarSubModuloService(subModuloRequestDto);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listado-modulo-cbo")
    public ResponseEntity<List<SubModuloResponseDto>> listModuloCboController(){
        try{
            List<SubModuloResponseDto> moduloResponseDtoList = subModuloService.listModuloCboService();
            return ResponseEntity.ok(moduloResponseDtoList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
