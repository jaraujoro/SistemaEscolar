package com.sistema.escuela.modulo.repository;

import com.sistema.escuela.modulo.dto.ModuloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ModuloRepository {

    private final ModuloRepositoryParams moduloRepositoryParams;

    @Autowired
    public ModuloRepository(ModuloRepositoryParams moduloRepositoryParams) {
        this.moduloRepositoryParams = moduloRepositoryParams;
    }

    // Listar módulos
    public List<ModuloResponseDto> listModuloRepository(int op, String where) {
        Map<String, Object> out = moduloRepositoryParams.getSpModuloRpt()
                .execute(moduloRepositoryParams.buildParamsRpt(
                        Map.of(
                                "op", op,
                                "where", where
                        )
                ));
        return (List<ModuloResponseDto>) out.get("result");
    }

    // Guardar módulo
    public List<ModuloResponseDto> guardarModuloRepository(int op, String v1, String v2, String v3, String v4, String v5, String v6) {
        Map<String, Object> out = moduloRepositoryParams.getSpModuloData()
                .execute(moduloRepositoryParams.buildParamsData(
                        Map.of(
                                "op", op,
                                "v1", v1,
                                "v2", v2,
                                "v3", v3,
                                "v4", v4,
                                "v5", v5,
                                "v6", v6
                        )
                ));
        return (List<ModuloResponseDto>) out.get("result");
    }

    // Editar módulo
    public List<ModuloResponseDto> editarModuloRepository(int op, String v1, String v2, String v3, String v4, String v5, String v6, String v7) {
        Map<String, Object> out = moduloRepositoryParams.getSpModuloData()
                .execute(moduloRepositoryParams.buildParamsData(
                        Map.of(
                                "op", op,
                                "v1", v1,
                                "v2", v2,
                                "v3", v3,
                                "v4", v4,
                                "v5", v5,
                                "v6", v6,
                                "v7", v7
                        )
                ));
        return (List<ModuloResponseDto>) out.get("result");
    }

    // Eliminar módulo
    public List<ModuloResponseDto> eliminarModuloRepository(int op, String v1) {
        Map<String, Object> out = moduloRepositoryParams.getSpModuloData()
                .execute(moduloRepositoryParams.buildParamsData(
                        Map.of(
                                "op", op,
                                "v1", v1
                        )
                ));
        return (List<ModuloResponseDto>) out.get("result");
    }
}
