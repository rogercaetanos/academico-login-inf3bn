package com.itb.lip2.academicologininf3bn.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "Aluno")
public class Aluno extends Usuario {

    private String rm;

    public Aluno() {

    }
    public Aluno(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
        super(id, nome, email, senha, papeis);
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }


}
