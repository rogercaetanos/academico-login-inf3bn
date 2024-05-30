package com.itb.lip2.academicologininf3bn.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "Funcionario")
public class Funcionario extends Usuario {

    public Funcionario() {

    }

    public Funcionario(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
        super(id, nome, email, senha, papeis);
    }



}
