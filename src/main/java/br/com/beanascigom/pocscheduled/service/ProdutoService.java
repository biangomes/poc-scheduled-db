package br.com.beanascigom.pocscheduled.service;

import br.com.beanascigom.pocscheduled.model.Produto;
import br.com.beanascigom.pocscheduled.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto getById(Long id) {
        var result = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto com ID: " + id + " nao encontrado.")
        );
        return result;
    }

    // TODO : 500 Internal Server Erro mesmo havendo registro no banco
    public List<Produto> getAllProdutosPorNome(String nome) {
        List<Produto> result = repository.findProdutosByNome(nome.toLowerCase());

        if (result.isEmpty()) {
            throw new EntityNotFoundException("Não existem produtos com esse nome: " + nome);
        }

        return result;
    }

    public List<Produto> getAllProdutosPorFaixaDePreco(BigDecimal menorPreco, BigDecimal maiorPreco) {
        List<Produto> result = repository.findAllByPrecoGreaterThanEqualAndPrecoIsLessThan(menorPreco, maiorPreco);

        if (result.isEmpty()) {
            throw new EntityNotFoundException("Não existem produtos nessa faixa de preço!");
        }

        return result;
    }
}
