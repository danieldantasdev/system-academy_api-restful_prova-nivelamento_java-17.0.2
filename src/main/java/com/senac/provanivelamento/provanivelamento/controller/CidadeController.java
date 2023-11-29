package com.senac.provanivelamento.provanivelamento.controller;

import com.senac.provanivelamento.provanivelamento.entity.Cidade;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/list")
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> rotas = cidadeService.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getRota(@PathVariable Long id) {
        Optional<Cidade> rota = cidadeService.findById(id);
        if (rota.isPresent()) {
            return ResponseEntity.ok(rota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cidade> insert(@RequestBody Cidade newRota) {
        Cidade rota = cidadeService.save(newRota);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> replace(@RequestBody Cidade newRota, @PathVariable Long id) {
        Cidade rota = cidadeService.update(newRota, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = cidadeService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
