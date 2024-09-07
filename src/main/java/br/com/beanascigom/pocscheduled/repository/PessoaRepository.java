package br.com.beanascigom.pocscheduled.repository;

import br.com.beanascigom.pocscheduled.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findById(Long id);

    @Query(value = br.com.beanascigom.pocscheduled.repository.Query.CREATE_PEOPLE, nativeQuery = true)
    String executeFunction(@Param("nome") String nome, @Param("email") String email);
}
