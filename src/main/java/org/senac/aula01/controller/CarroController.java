package org.senac.aula01.controller;

import org.senac.aula01.entity.Carro;
import org.senac.aula01.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody @Valid Carro carro) {
        if (carro.getAvaliacoes() != null) {
            carro.getAvaliacoes().stream().forEach(a -> a.setCarro(carro));
        }
        Carro c = repository.save(carro);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Carro> findAll() {
        return repository.findAllWithMarca();
    }

}
