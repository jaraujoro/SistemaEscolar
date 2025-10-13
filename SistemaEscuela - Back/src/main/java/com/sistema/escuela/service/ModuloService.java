package com.sistema.escuela.service;

import com.sistema.escuela.model.Modulo;
import com.sistema.escuela.repository.ModuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModuloService {
    
    @Autowired
    ModuloRepository moduloRepository;
    
    public List<Modulo> listModuloService(){
        return moduloRepository.findAll();
    }  
    
    public Modulo guardarModuloService(Modulo modulo){
        return moduloRepository.save(modulo);
    }
    
    public void eliminarModuloService(Long id){
        moduloRepository.deleteById(id);
    }
}
