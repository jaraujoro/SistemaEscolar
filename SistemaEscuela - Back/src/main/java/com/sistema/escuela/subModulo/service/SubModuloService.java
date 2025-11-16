
package com.sistema.escuela.subModulo.service;

import com.sistema.escuela.subModulo.dto.SubModuloRequestDto;
import com.sistema.escuela.subModulo.dto.SubModuloResponseDto;
import com.sistema.escuela.subModulo.repository.SubModuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubModuloService {
    
    @Autowired
    SubModuloRepository subModuloRepository;

    public List<SubModuloResponseDto> listSubModuloService(SubModuloRequestDto subModuloRequestDto) {
        int op = 1;
        String where = subModuloRequestDto.getWhere();
        return subModuloRepository.listSubModuloRepository(op, where);
    }
    public SubModuloResponseDto eliminarSubModuloService(SubModuloRequestDto subModuloRequestDto){
        int op = 1;
        String v1 = subModuloRequestDto.getId_sub_modulo();
        List<SubModuloResponseDto> result = subModuloRepository.eliminarSubModuloRepository(op, v1);
        return result.get(0);
    }

    public List<SubModuloResponseDto>  listModuloCboService(){
        int op = 2;
        return subModuloRepository.listModuloCboRepository(op);
    }
}
