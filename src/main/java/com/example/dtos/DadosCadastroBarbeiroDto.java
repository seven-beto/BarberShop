package com.example.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroBarbeiroDto(

        Long id,

        @NotBlank(message = "Nome obrigatorio")
        String nome,

        @NotBlank(message = "Email obrigatorio")
        @Email(message = "Email obrigatorio")
        String email) {
}
