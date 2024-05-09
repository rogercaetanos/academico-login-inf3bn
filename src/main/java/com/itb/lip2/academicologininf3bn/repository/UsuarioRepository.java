package com.itb.lip2.academicologininf3bn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.lip2.academicologininf3bn.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

}
