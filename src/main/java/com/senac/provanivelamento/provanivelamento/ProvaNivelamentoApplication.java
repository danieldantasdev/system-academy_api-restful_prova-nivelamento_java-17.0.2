package com.senac.provanivelamento.provanivelamento;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Prova de Nivelamento", version = "2.0", description = "Prova"))
public class ProvaNivelamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaNivelamentoApplication.class, args);
    }

}