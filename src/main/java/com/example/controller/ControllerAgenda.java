package com.example.controller;

import com.example.dtos.DadosAgendadto;
import com.example.repository.AgendaRepository;
import com.example.service.ServiceAgenda;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/agenda")
public class ControllerAgenda {

    @Autowired
    private ServiceAgenda serviceAgenda;

    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    @Transactional
    public ResponseEntity list(DadosAgendadto dados){
        var allList = agendaRepository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity agenda(@RequestBody @Valid DadosAgendadto dados){
        var Marcar = serviceAgenda.agendar(dados);
        return new ResponseEntity<>(Marcar, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity FindByData(@RequestParam LocalDateTime dataCortes){
        var find = agendaRepository.FindByDataCortes(dataCortes);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

}
