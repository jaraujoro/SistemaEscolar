package com.sistema.escuela.repository.ModuloRepository;

import com.sistema.escuela.dto.modulo.ModuloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class ModuloRepositoryParams {

    private final SimpleJdbcCall spModuloRpt;
    private final SimpleJdbcCall spModuloData;

    @Autowired
    public ModuloRepositoryParams(JdbcTemplate jdbcTemplate) {

        // 🔹 SP para listar módulos (RPT)
        this.spModuloRpt = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("ADM")
                .withProcedureName("sp_modulo_rpt")
                .returningResultSet("result",
                        BeanPropertyRowMapper.newInstance(ModuloResponseDto.class));

        // 🔹 SP para guardar/editar/eliminar módulos (DATA)
        this.spModuloData = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("ADM")
                .withProcedureName("sp_modulo_data")
                .returningResultSet("result",
                        BeanPropertyRowMapper.newInstance(ModuloResponseDto.class));
    }

    // 🔹 Build para SP de reporte (ADM.sp_modulo_rpt)
    public MapSqlParameterSource buildParamsRpt(Map<String, Object> paramsMap) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        // Los parámetros reales del SP rpt
        String[] keys = {"op", "v1", "v2", "v3", "v4", "v5", "where"};

        for (String key : keys) {
            Object value = paramsMap.getOrDefault(key, "");
            params.addValue(key, value != null ? value : "");
        }

        return params;
    }

    // 🔹 Build para SP de mantenimiento (ADM.sp_modulo_data)
    public MapSqlParameterSource buildParamsData(Map<String, Object> paramsMap) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        // Los parámetros reales del SP data
        String[] keys = {"op", "v1", "v2", "v3", "v4", "v5", "v6", "v7"};

        for (String key : keys) {
            Object value = paramsMap.getOrDefault(key, "");
            params.addValue(key, value != null ? value : "");
        }

        return params;
    }

    public SimpleJdbcCall getSpModuloRpt() {
        return spModuloRpt;
    }

    public SimpleJdbcCall getSpModuloData() {
        return spModuloData;
    }
}
