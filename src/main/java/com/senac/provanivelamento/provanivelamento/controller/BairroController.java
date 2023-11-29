package com.senac.provanivelamento.provanivelamento.controller;

import com.senac.provanivelamento.provanivelamento.entity.Bairro;
import com.senac.provanivelamento.provanivelamento.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @GetMapping
    public ResponseEntity<List<Bairro>> getAllBairros() {
        return ResponseEntity.ok(bairroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bairro> getBairroById(@PathVariable Long id) {
        return bairroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bairro> createBairro(@RequestBody Bairro bairro) {
        return ResponseEntity.ok(bairroService.save(bairro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bairro> updateBairro(@PathVariable Long id, @RequestBody Bairro bairro) {
        if (!bairroService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bairro.setId(id);
        return ResponseEntity.ok(bairroService.save(bairro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBairro(@PathVariable Long id) {
        if (!bairroService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bairroService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}