package br.com.beanascigom.pocscheduled.repository;

import br.com.beanascigom.pocscheduled.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
    @Query(value = "select p from Produto p where p.nome like '%:nome%'")
    List<Produto> findProdutosByNome(String nome);
    List<Produto> findAllByPrecoGreaterThanEqualAndPrecoIsLessThan(BigDecimal precoMinimo, BigDecimal precoMaximo);
}
