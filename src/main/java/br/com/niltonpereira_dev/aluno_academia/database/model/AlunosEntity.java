package br.com.niltonpereira_dev.aluno_academia.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AlunosEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;


    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacoesFisicaEntity avaliacoesFisica;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<TreinosEntity> treinos = new HashSet<>();

}
