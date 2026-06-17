package br.com.niltonpereira_dev.aluno_academia.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacoesFisicaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "peso", nullable = false)
    private BigDecimal peso;

    @Column(name = "altura", nullable = false)
    private BigDecimal altura;

    @Column(name = "porcentual_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;
}
