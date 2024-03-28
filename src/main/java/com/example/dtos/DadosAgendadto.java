package com.example.dtos;

import java.time.LocalDateTime;

public record DadosAgendadto(Long id, Long idBarbeiro, Long idCliente, LocalDateTime dataCortes) {
}
