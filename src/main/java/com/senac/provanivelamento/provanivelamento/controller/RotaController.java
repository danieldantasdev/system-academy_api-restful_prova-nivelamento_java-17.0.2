package com.senac.provanivelamento.provanivelamento.controller;

import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @GetMapping("/list")
    public ResponseEntity<List<Rota>> findAll() {
        List<Rota> rotas = rotaService.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> getRota(@PathVariable Long id) {
        Optional<Rota> rota = rotaService.findById(id);
        if(rota.isPresent()) {
            return ResponseEntity.ok(rota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rota> insert(@RequestBody Rota newRota) {
        Rota rota = rotaService.save(newRota);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> replace(@RequestBody Rota newRota, @PathVariable Long id) {
        Rota rota = rotaService.update(newRota, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = rotaService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
