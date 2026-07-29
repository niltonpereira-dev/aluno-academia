package br.com.niltonpereira_dev.aluno_academia.exception;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErroResponse {

    private String message;
    private Integer status;
}
