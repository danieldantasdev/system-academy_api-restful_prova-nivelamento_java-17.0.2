package com.senac.provanivelamento.provanivelamento.service;

import com.senac.provanivelamento.provanivelamento.entity.Endereco;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.repository.EnderecoRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepositoy enderecoRepositoy;

    public List<Endereco> listAll() {
        return enderecoRepositoy.findAll();
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepositoy.findById(id);
    }

    @Transactional
    public Endereco save(Endereco rota) {
        return enderecoRepositoy.save(rota);
    }

    @Transactional
    public Endereco update(Endereco newRota, Long id) {
        Optional<Endereco> rotaOptional = findById(id);
        if (rotaOptional.isPresent()) {
            Endereco rota = rotaOptional.get();
            rota.setEstado(newRota.getEstado());
            rota.setCep(newRota.getCep());
            rota.setBairro(newRota.getBairro());
            rota.setCidade(newRota.getCidade());
            return save(rota);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        Optional<Endereco> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> enderecoRepositoy.delete(rota));
        return rotaOptional.isPresent();
    }
}