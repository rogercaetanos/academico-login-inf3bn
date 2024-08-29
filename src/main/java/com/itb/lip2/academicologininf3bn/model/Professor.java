package com.itb.lip2.academicologininf3bn.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Professor")
public class Professor extends Usuario {

    private int pontuacao;
    private String nivelProfissional;


    @OneToMany(mappedBy = "professor")                  // Um professor possui vários cursos
    @JsonIgnore                                        // Na api, ignoramos um lado da relação para evitar o looping infinito
    private List<Curso> cursos = new ArrayList<Curso>();


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
