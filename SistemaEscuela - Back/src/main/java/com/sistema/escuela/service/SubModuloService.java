
package com.sistema.escuela.service;

import com.sistema.escuela.dto.subModulo.SubModuloDto;
import com.sistema.escuela.repository.SubModuloRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubModuloService {
    
    @Autowired
    SubModuloRepository subModuloRepository;
    
    public List<SubModuloDto> listSubModuloService(){
        List<SubModuloDto> listSubModuloDto = new ArrayList<>();
        return listSubModuloDto;
    }
}
