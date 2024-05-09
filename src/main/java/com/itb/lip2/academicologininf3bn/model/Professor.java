package com.itb.lip2.academicologininf3bn.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "Professor")
public class Professor extends Usuario {

    private int pontuacao;
    private String nivelProfissional;


    public Professor() {

    }

    public Professor(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
        super(id, nome, email, senha, papeis);
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNivelProfissional() {
        return nivelProfissional;
    }

    public void setNivelProfissional(String nivelProfissional) {
        this.nivelProfissional = nivelProfissional;
    }
}
