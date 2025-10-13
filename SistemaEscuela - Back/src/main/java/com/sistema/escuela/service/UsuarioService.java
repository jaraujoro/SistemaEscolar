package com.sistema.escuela.service;

import com.sistema.escuela.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.escuela.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Usuario> listTodas() {
        return usuarioRepository.findAll();
    }
    
    public String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean verificarPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    
    public Usuario guardar(Usuario usuario) {
        usuario.setPasswordUsuario(passwordEncoder.encode(usuario.getPasswordUsuario()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByLogin(String loginUsuario) {
        return usuarioRepository.findByLoginUsuario(loginUsuario);
    }
    
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
