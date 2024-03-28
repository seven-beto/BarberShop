package com.example.controller;



import com.example.domain.Barbeiro;
import com.example.dtos.DadosCadastroBarbeiroDto;
import com.example.repository.BarbeiroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbeiro")
public class ControllerBarbeiro {

    @Autowired
    private BarbeiroRepository repository;

    @GetMapping
    @Transactional
    public ResponseEntity all(DadosCadastroBarbeiroDto dados){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroBarbeiroDto dados){
        var cadastro = repository.save(new Barbeiro(dados));
        return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosCadastroBarbeiroDto dados){
        var update = repository.getReferenceById(dados.id());
        update.atualizando(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
