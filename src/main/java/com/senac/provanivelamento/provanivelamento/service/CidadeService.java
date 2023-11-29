package com.senac.provanivelamento.provanivelamento.service;

import com.senac.provanivelamento.provanivelamento.entity.Cidade;
import com.senac.provanivelamento.provanivelamento.repository.CidadeRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepositoy cidadeRepositoy;

    public List<Cidade> listAll() {
        return cidadeRepositoy.findAll();
    }

    public Optional<Cidade> findById(Long id) {
        return cidadeRepositoy.findById(id);
    }

    @Transactional
    public Cidade save(Cidade rota) {
        return cidadeRepositoy.save(rota);
    }

    @Transactional
    public Cidade update(Cidade newRota, Long id) {
        Optional<Cidade> rotaOptional = findById(id);
        if (rotaOptional.isPresent()) {
            Cidade rota = rotaOptional.get();
            rota.setEstado(newRota.getEstado());
            rota.setNome(newRota.getNome());
            rota.setStatus(newRota.getStatus());
            return save(rota);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        Optional<Cidade> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> cidadeRepositoy.delete(rota));
        return rotaOptional.isPresent();
    }
}