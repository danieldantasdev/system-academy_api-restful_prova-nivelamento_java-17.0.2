package com.senac.provanivelamento.provanivelamento.service;

import com.senac.provanivelamento.provanivelamento.entity.Estado;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.repository.EstadoRepository;
import com.senac.provanivelamento.provanivelamento.repository.RotaRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepositoy;

    public List<Estado> listAll() {
        return estadoRepositoy.findAll();
    }

    public Optional<Estado> findById(Long id) {
        return estadoRepositoy.findById(id);
    }

    @Transactional
    public Estado save(Estado rota) {
        return estadoRepositoy.save(rota);
    }

    @Transactional
    public Estado update(Estado newEstado, Long id) {
        Optional<Estado> rotaOptional = findById(id);
        if (rotaOptional.isPresent()) {
            Estado rota = rotaOptional.get();
            rota.setNome(newEstado.getNome());
            rota.setSigla(newEstado.getSigla());
            rota.setStatus(newEstado.getStatus());
            rota.setStatus(newEstado.getStatus());
            return save(rota);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        Optional<Estado> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> estadoRepositoy.delete(rota));
        return rotaOptional.isPresent();
    }
}