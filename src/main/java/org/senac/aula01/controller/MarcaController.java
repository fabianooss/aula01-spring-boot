package org.senac.aula01.controller;

import org.apache.coyote.Response;
import org.senac.aula01.entity.Marca;
import org.senac.aula01.repository.MarcaRepository;
import org.senac.aula01.vo.ValorMedioMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
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

    @GetMapping
    public List<Marca> get(@RequestParam(required = false, defaultValue = "nome") String orderField,
                           @RequestParam(required = false) String filter){
        if (filter != null) {
            return marcaRepository.findByNomeContainingOrderByIdDesc(filter);
        }
        Sort order = Sort.by(Sort.Direction.ASC, orderField);
        return marcaRepository.findAll(order);

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
    public ResponseEntity<Marca> salvar(@RequestBody @Valid Marca marca) {
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

    @GetMapping("/valorMedio")
    public List<ValorMedioMarca> getValorMedio() {
        return marcaRepository.findValorMedio();
    }

}
