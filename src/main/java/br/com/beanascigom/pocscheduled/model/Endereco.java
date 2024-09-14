package br.com.beanascigom.pocscheduled.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Endereco {
    public Endereco(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String municipio;
    private String estado;
    private String pais;
    @OneToMany(mappedBy = "endereco")
    private List<PessoaEndereco> pessoaEndereco;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<PessoaEndereco> getPessoaEndereco() {
        return pessoaEndereco;
    }

    public void setPessoaEndereco(List<PessoaEndereco> pessoaEndereco) {
        this.pessoaEndereco = pessoaEndereco;
    }
}
