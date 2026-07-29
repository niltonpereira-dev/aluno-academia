package br.com.niltonpereira_dev.aluno_academia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AlunoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
