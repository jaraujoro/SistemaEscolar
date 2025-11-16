package com.sistema.escuela.usuario.controller;

import com.sistema.escuela.usuario.model.Usuario;
import com.sistema.escuela.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService personaService;

    /*@GetMapping
    public String listarPersona(Model model) {
        model.addAttribute("personas", personaService.listTodas());
        return "persona-list";
    }*/

    /*@GetMapping("/nuevo")
    public String mostrarFormularioNuevoPersona(Model model) {
        model.addAttribute("persona", new Usuario());
        return "persona-form";
    }*/

    @PostMapping("/registrar-usuario")
    @ResponseBody
    public String guardarPersona(@RequestBody Usuario usuario) {
        try{
            personaService.guardar(usuario);
            return "Usuario registrado correctamente";
        }catch(Exception e){
            return "Error al registrar el usuario " + e.getMessage();
        }
    }

    @PostMapping("/login-validate")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuarioRequest) {
        Optional<Usuario> usuarioOpt = personaService.findByLogin(usuarioRequest.getLoginUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        if (!personaService.verificarPassword(usuarioRequest.getPasswordUsuario(), usuario.getPasswordUsuario())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }
        usuario.setPasswordUsuario(null);
        return ResponseEntity.ok(usuario);
    }

    /*@GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-form";
    }*/

    /*@GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return "redirect:/personas";
    }*/
}
