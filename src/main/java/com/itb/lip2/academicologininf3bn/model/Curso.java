package com.itb.lip2.academicologininf3bn.model;


import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private boolean codStatus;

    // Relacionamento  ( 1: N )
    @ManyToOne(cascade = CascadeType.ALL)                              // Muitos cursos para um professor
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")      // identificação da chave estrangeira (FK)
    private Professor professor;

}
