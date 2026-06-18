package br.com.niltonpereira_dev.aluno_academia.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ExerciciosDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;

}
