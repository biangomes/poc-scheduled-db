package br.com.beanascigom.pocscheduled.service;

import br.com.beanascigom.pocscheduled.model.Pessoa;
import br.com.beanascigom.pocscheduled.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa getById(Long id) {
        var result = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa com id " + id + " não foi encontrada."));
        return result;
    }

    public String saveScheduling() {
        try {
            var func = repository.executeFunction("a", "a@gmail.com");
            return func;
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
