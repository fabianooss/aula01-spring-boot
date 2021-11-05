package org.senac.aula01.controller;

import org.apache.coyote.Response;
import org.senac.aula01.entity.Marca;
import org.senac.aula01.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;


    static List<Marca> marcas = new ArrayList<>();

    static {
        Marca m = new Marca();
        m.setId(1L);
        m.setNome("VW");
        marcas.add(m);

        m = new Marca();
        m.setId(2L);
        m.setNome("Ford");
        marcas.add(m);

        m = new Marca();
        m.setId(3L);
        m.setNome("GM");
        marcas.add(m);
    }

    @GetMapping
    public List<Marca> get(){
        return marcaRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable("id") Long id) {
        Optional<Marca> m = marcaRepository.findById(id);

        if (m.isPresent()) {
            return ResponseEntity.ok(m.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Marca> salvar(@RequestBody Marca marca) {
        Marca nova = marcaRepository.save(marca);
        return ResponseEntity.ok(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable("id") Long id,
                                        @RequestBody Marca marca) {
        marcaRepository.save(marca);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> delete(@PathVariable("id") Long id) {
        marcaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
