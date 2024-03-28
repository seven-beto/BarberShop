package com.example.controller;


import com.example.domain.Cliente;
import com.example.dtos.DadosCadastroClienteDto;
import com.example.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity all(DadosCadastroClienteDto dados){
        var all = repository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroClienteDto dados){
         var cadastro = repository.save(new Cliente(dados));
         return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosCadastroClienteDto dados){
        var update = repository.getReferenceById(dados.id());
        update.atualizando(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
