package com.senac.provanivelamento.provanivelamento.controller;

import com.senac.provanivelamento.provanivelamento.entity.Estado;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/list")
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> rotas = estadoService.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getRota(@PathVariable Long id) {
        Optional<Estado> rota = estadoService.findById(id);
        if (rota.isPresent()) {
            return ResponseEntity.ok(rota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estado> insert(@RequestBody Estado newRota) {
        Estado rota = estadoService.save(newRota);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> replace(@RequestBody Estado newEstado, @PathVariable Long id) {
        Estado rota = estadoService.update(newEstado, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = estadoService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
