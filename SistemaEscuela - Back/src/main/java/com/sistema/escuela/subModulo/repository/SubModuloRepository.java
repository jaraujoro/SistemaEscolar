package com.sistema.escuela.subModulo.repository;

import com.sistema.escuela.subModulo.dto.SubModuloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class SubModuloRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SubModuloRepositoryParams subModuloRepositoryParams;


    public List<SubModuloResponseDto> listSubModuloRepository(int op, String where) {

        String sql = subModuloRepositoryParams.rpt(
                Map.of("op", op, "where", where)
        );

        return jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SubModuloResponseDto.class)
        );
    }

    public List<SubModuloResponseDto> eliminarSubModuloRepository(int op, String idSubModulo) {
        String sql = "EXEC ADM.sp_sub_modulo_data @op = ?, @v1 = ?";

        Object[] params = {
                op,
                idSubModulo
        };

        return jdbcTemplate.query(
                sql,
                params,
                BeanPropertyRowMapper.newInstance(SubModuloResponseDto.class)
        );
    }

    public List<SubModuloResponseDto> listModuloCboRepository(int op){
        String sql = subModuloRepositoryParams.rpt(
                Map.of("op", op)
        );
        return jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SubModuloResponseDto.class)
        );
    }
}
