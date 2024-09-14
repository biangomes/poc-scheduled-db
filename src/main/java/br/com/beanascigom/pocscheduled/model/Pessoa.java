package br.com.beanascigom.pocscheduled.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nome;
    @Column(length = 11)
    private String cpf;
    @Column(length = 255)
    private String email;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<PessoaEndereco> endereco;
}
