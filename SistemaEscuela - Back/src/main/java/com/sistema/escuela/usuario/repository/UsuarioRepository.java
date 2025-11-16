
package com.sistema.escuela.usuario.repository;

import com.sistema.escuela.usuario.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLoginUsuario(String loginUsuario);
}
