package com.example.repository;

import com.example.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    public List<Agenda>FindByDataCortes(LocalDateTime dataCortes);
}
