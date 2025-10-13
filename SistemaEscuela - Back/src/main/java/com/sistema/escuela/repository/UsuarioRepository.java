
package com.sistema.escuela.repository;

import com.sistema.escuela.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLoginUsuario(String loginUsuario);
}
