package com.example.domain;

import com.example.dtos.DadosCadastroBarbeiroDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "barbeiro")
@Entity(name = "Barbeiro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    public Barbeiro(DadosCadastroBarbeiroDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
    }

    public void atualizando(DadosCadastroBarbeiroDto dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }
}
