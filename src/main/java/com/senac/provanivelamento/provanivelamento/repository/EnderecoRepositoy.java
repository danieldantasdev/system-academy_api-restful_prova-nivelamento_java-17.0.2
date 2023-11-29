package com.senac.provanivelamento.provanivelamento.repository;

import com.senac.provanivelamento.provanivelamento.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositoy extends JpaRepository<Endereco, Long> {
}
