package com.example.service;


import com.example.domain.Agenda;
import com.example.domain.Barbeiro;
import com.example.domain.Cliente;
import com.example.dtos.DadosAgendadto;
import com.example.repository.AgendaRepository;
import com.example.repository.BarbeiroRepository;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceAgenda {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Agenda agendar(DadosAgendadto dados){
        Barbeiro barbeiro = barbeiroRepository.findById(dados.idBarbeiro()).get();
        Cliente cliente = clienteRepository.findById(dados.idCliente()).get();
        Agenda agenda = new Agenda();
        agenda.setIdBarbeiro(barbeiro);
        agenda.setIdCliente(cliente);
        agenda.setDataCortes(dados.dataCortes());

        return agendaRepository.save(agenda);
    }

    public List<Agenda>FindByDataCortes(LocalDateTime dataCortes){
        return agendaRepository.FindByDataCortes(dataCortes);
    }

}
