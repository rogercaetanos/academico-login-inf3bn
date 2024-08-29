package com.itb.lip2.academicologininf3bn.repository;

import com.itb.lip2.academicologininf3bn.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PapelRepository extends JpaRepository<Papel, Long> {

    @Query(value = "SELECT * FROM papeis p WHERE p.nome_papel=?", nativeQuery = true)
    Papel findByNomePapel(String nome);
}
