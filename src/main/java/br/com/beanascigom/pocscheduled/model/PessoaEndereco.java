package br.com.beanascigom.pocscheduled.model;

import jakarta.persistence.*;

@Entity
public class PessoaEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa", nullable = false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "endereco", nullable = false)
    private Endereco endereco;
}
