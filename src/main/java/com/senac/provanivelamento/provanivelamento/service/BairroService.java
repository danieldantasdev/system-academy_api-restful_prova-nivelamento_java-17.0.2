package com.senac.provanivelamento.provanivelamento.service;

import com.senac.provanivelamento.provanivelamento.entity.Bairro;
import com.senac.provanivelamento.provanivelamento.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Optional<Bairro> findById(Long id) {
        return bairroRepository.findById(id);
    }

    public Bairro save(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public void deleteById(Long id) {
        bairroRepository.deleteById(id);
    }
}