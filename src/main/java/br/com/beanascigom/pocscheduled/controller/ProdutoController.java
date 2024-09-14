package br.com.beanascigom.pocscheduled.controller;

import br.com.beanascigom.pocscheduled.model.Produto;
import br.com.beanascigom.pocscheduled.repository.ProdutoRepository;
import br.com.beanascigom.pocscheduled.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {
    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository) {
        this.produtoService = produtoService;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(produtoService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getAllPorNome(@PathVariable("nome") String nome) {
        return new ResponseEntity<>(produtoService.getAllProdutosPorNome(nome), HttpStatus.OK);
    }

    @GetMapping("") // produto?menor=100&maior=1000
    public ResponseEntity<List<Produto>> getAllPorFaixaDePreco(@RequestParam BigDecimal menor, @RequestParam BigDecimal maior) {
        List<Produto> result;
        if (menor.equals(null) || maior.equals(null)) {
            result = produtoRepository.findAll();
        } else {
            result = produtoService.getAllProdutosPorFaixaDePreco(menor, maior);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
