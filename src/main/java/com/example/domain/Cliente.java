package com.example.domain;

import com.example.dtos.DadosCadastroClienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Column(unique = true)
    private String cpf;

    public Cliente(DadosCadastroClienteDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
    }

    public void atualizando(DadosCadastroClienteDto dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
    }
}
