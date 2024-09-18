package com.itb.lip2.academicologininf3bn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.lip2.academicologininf3bn.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);


    @Query(value = "SELECT * FROM usuarios u WHERE u.email=?", nativeQuery = true)
    Usuario findByEmail(String email);


}
