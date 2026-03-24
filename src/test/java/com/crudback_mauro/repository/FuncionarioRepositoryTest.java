package com.crudback_mauro.repository;

import com.crudback_mauro.model.Funcionario;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Test
    void deveSalvarEBuscarFuncionario() {
        Funcionario funcionario = Funcionario.builder()
                .nome("Mauro")
                .cargo("Dev")
                .build();

        Funcionario salvo = funcionarioRepository.saveAndFlush(funcionario);

        assertThat(salvo.getId()).isNotNull();
        assertThat(funcionarioRepository.findById(salvo.getId())).isPresent();
    }

    @Test
    void naoDeveSalvarFuncionarioSemNome() {
        Funcionario invalido = Funcionario.builder()
                .nome("")
                .cargo("Dev")
                .build();

        assertThatThrownBy(() -> funcionarioRepository.saveAndFlush(invalido))
                .isInstanceOf(ConstraintViolationException.class);
    }
}

