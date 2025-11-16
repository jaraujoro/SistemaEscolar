package com.sistema.escuela.subModulo.repository;

import org.springframework.stereotype.Component;

import java.util.Map;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class SubModuloRepositoryParams {

    // 🔹 SP de reporte
    public String rpt(Map<String, Object> p) {
        return "EXEC ADM.sp_sub_modulo_rpt " +
                "@op = '" + p.getOrDefault("op", "") + "', " +
                "@v1 = '" + p.getOrDefault("v1", "") + "', " +
                "@v2 = '" + p.getOrDefault("v2", "") + "', " +
                "@v3 = '" + p.getOrDefault("v3", "") + "', " +
                "@v4 = '" + p.getOrDefault("v4", "") + "', " +
                "@v5 = '" + p.getOrDefault("v5", "") + "', " +
                "@where = '" + p.getOrDefault("where", "") + "'";
    }

    // 🔹 SP de mantenimiento
    public String data(Map<String, Object> p) {
        return "EXEC ADM.sp_sub_modulo_data " +
                "@op = '" + p.getOrDefault("op", "") + "', " +
                "@v1 = '" + p.getOrDefault("v1", "") + "', " +
                "@v2 = '" + p.getOrDefault("v2", "") + "', " +
                "@v3 = '" + p.getOrDefault("v3", "") + "', " +
                "@v4 = '" + p.getOrDefault("v4", "") + "', " +
                "@v5 = '" + p.getOrDefault("v5", "") + "', " +
                "@v6 = '" + p.getOrDefault("v6", "") + "', " +
                "@v7 = '" + p.getOrDefault("v7", "") + "'";
    }
}
