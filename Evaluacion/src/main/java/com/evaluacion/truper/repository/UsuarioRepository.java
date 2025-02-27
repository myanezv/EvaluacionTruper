package com.evaluacion.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.evaluacion.truper.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.usuario_nombre=:usuario_nombre")
	Usuario findByUsuario_nombre(@Param("usuario_nombre") String usuario_nombre);
}
