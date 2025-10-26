package com.sistema.escuela.service;

import com.sistema.escuela.dto.modulo.ModuloRequestDto;
import com.sistema.escuela.model.Modulo;
import com.sistema.escuela.repository.ModuloRepository.ModuloRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.escuela.dto.modulo.ModuloResponseDto;

@Service
public class ModuloService {

    @Autowired
    ModuloRepository moduloRepository;

    public List<ModuloResponseDto> listModuloService(ModuloRequestDto moduloRequestDto) {
        int op = 1;
        String where = moduloRequestDto.getWhere();
        return moduloRepository.listModuloRepository(op, where);
    }

    @Transactional
    public ModuloResponseDto guardarModuloService(ModuloRequestDto moduloRequestDto) {
        int op = 1;
        String v1 = moduloRequestDto.getEstado_modulo();
        String v2 = moduloRequestDto.getIcono_modulo();
        String v3 = moduloRequestDto.getNivel_modulo();
        String v4 = moduloRequestDto.getNombre_modulo();
        String v5 = moduloRequestDto.getUrl_modulo();
        String v6 = moduloRequestDto.getId_usuario();
        List<ModuloResponseDto> result = moduloRepository.guardarModuloRepository(op, v1, v2, v3, v4, v5, v6);
        return result.get(0);
    }

    @Transactional
    public ModuloResponseDto eliminarModuloService(String id) {
        int op = 3;
        String v1 = id;
        List<ModuloResponseDto> resultDto = moduloRepository.eliminarModuloRepository(op, v1);
        return resultDto.get(0);
    }

    @Transactional
    public ModuloResponseDto editarModuloService(ModuloRequestDto moduloRequestDto) {
        int op = 2;
        String v1 = moduloRequestDto.getEstado_modulo();
        String v2 = moduloRequestDto.getIcono_modulo();
        String v3 = moduloRequestDto.getNivel_modulo();
        String v4 = moduloRequestDto.getNombre_modulo();
        String v5 = moduloRequestDto.getUrl_modulo();
        String v6 = moduloRequestDto.getId_usuario();
        String v7 = moduloRequestDto.getId_modulo();
        List<ModuloResponseDto> resultDto = moduloRepository.editarModuloRepository(op, v1, v2, v3, v4, v5, v6, v7);
        return resultDto.get(0);
    }
}
