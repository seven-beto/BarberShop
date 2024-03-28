package com.example.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroClienteDto(

        Long id,

        @NotBlank(message = "Nome obrigatorio")
        String nome,

        @NotBlank(message = "Email obrigatorio")
        String email,

        @NotNull(message = "Cpf obrigatorio")
        String cpf) {
}
