package br.com.niltonpereira_dev.aluno_academia.dto;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection {

    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGorduraCorporal();
}
