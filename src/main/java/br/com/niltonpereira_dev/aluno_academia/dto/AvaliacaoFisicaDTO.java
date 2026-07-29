package br.com.niltonpereira_dev.aluno_academia.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AvaliacaoFisicaDTO {

    @NotNull
    private Integer alunoID;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal percentualGorduraCorporal;

}
