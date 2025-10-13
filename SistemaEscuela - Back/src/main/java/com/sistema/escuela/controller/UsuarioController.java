package com.sistema.escuela.controller;

import com.sistema.escuela.model.Usuario;
import com.sistema.escuela.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
