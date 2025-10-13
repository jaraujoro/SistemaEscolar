package com.sistema.escuela.controller;

import com.sistema.escuela.model.Usuario;
import com.sistema.escuela.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login-controller")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login-validate")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuarioRequest) {
        Optional<Usuario> usuarioOpt = usuarioService.findByLogin(usuarioRequest.getLoginUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        if (!usuarioService.verificarPassword(usuarioRequest.getPasswordUsuario(), usuario.getPasswordUsuario())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }
        usuario.setPasswordUsuario(null);
        return ResponseEntity.ok(usuario);
    }
}














/*  
    @GetMapping("/registro-usuario")
    public String mostrarRegistro() {
        return "registro-usuario"; // busca templates/login.html
    }

    @GetMapping("/dashboard")
    public String mostrarPaginaPrincipal() {
        return "redirect:/build/index.html";
    }
*/
