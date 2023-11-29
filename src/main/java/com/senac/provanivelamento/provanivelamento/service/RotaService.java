package com.senac.provanivelamento.provanivelamento.service;

import com.senac.provanivelamento.provanivelamento.entity.Rota;
import com.senac.provanivelamento.provanivelamento.repository.RotaRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepositoy rotaRepository;

    public List<Rota> listAll() {
        return rotaRepository.findAll();
    }

    public Optional<Rota> findById(Long id) {
        return rotaRepository.findById(id);
    }

    @Transactional
    public Rota save(Rota rota) {
        return rotaRepository.save(rota);
    }

    @Transactional
    public Rota update(Rota newRota, Long id) {
        Optional<Rota> rotaOptional = findById(id);
        if(rotaOptional.isPresent()) {
            Rota rota = rotaOptional.get();
            rota.setInicio(newRota.getInicio());
            rota.setOtimizada(newRota.getOtimizada());
            rota.setStatus(newRota.getStatus());
            rota.setEndereco(newRota.getEndereco());
            return save(rota);
        } else{
            return null;
        }
    }

    public boolean delete(Long id) {
        Optional<Rota> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> rotaRepository.delete(rota));
        return rotaOptional.isPresent();
    }
}