package com.sistema.escuela.repository;

import com.sistema.escuela.model.SubModulo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubModuloRepository extends JpaRepository<SubModulo, Long> {

    @Query(value = "EXEC [ADM].[sp_sub_modulo_rpt] @op = 1", nativeQuery = true)
    List<Object[]> listSubModuloRepository();
    
    @Query(value = "EXEC [ADM].[sp_sub_modulo_rpt] @op = 2", nativeQuery = true)
    List<Object[]> listSubModuloCboRepository();
    
}
