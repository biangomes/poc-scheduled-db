package br.com.beanascigom.pocscheduled.controller;

import br.com.beanascigom.pocscheduled.model.Pessoa;
import br.com.beanascigom.pocscheduled.service.PessoaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping("pessoa/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
