package com.senac.provanivelamento.provanivelamento.repository;

import com.senac.provanivelamento.provanivelamento.entity.Cidade;
import com.senac.provanivelamento.provanivelamento.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepositoy extends JpaRepository<Cidade, Long> {
}
