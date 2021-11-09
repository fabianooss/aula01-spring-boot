package org.senac.aula01.controller;

import org.senac.aula01.entity.Opcional;
import org.senac.aula01.repository.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opcional")
public class OpcionalController {

    @Autowired
    private OpcionalRepository repository;


    @PostMapping
    public ResponseEntity<Opcional> save(@RequestBody Opcional opcional) {
        Opcional o = repository.save(opcional);
        return ResponseEntity.ok(o);
    }

    @GetMapping
    public List<Opcional> findAll() {
        return repository.findAll();
    }



}
