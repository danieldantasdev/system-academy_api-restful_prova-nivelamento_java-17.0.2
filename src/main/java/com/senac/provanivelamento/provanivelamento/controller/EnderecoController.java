package com.senac.provanivelamento.provanivelamento.controller;

import com.senac.provanivelamento.provanivelamento.entity.Endereco;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/list")
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> rotas = enderecoService.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getRota(@PathVariable Long id) {
        Optional<Endereco> rota = enderecoService.findById(id);
        if(rota.isPresent()) {
            return ResponseEntity.ok(rota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco newEndereco) {
        Endereco rota = enderecoService.save(newEndereco);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> replace(@RequestBody Endereco newRota, @PathVariable Long id) {
        Endereco rota = enderecoService.update(newRota, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = enderecoService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
