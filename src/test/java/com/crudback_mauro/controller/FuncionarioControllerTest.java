package com.crudback_mauro.controller;

import com.crudback_mauro.dto.FuncionarioDTO;
import com.crudback_mauro.service.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FuncionarioController.class)
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FuncionarioService funcionarioService;

    @Test
    void deveListarFuncionarios() throws Exception {
        FuncionarioDTO f = FuncionarioDTO.builder().id(1L).nome("Mauro").cargo("Dev").build();
        when(funcionarioService.listar()).thenReturn(List.of(f));

        mockMvc.perform(get("/funcionarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Mauro"));
    }

    @Test
    void deveBuscarFuncionarioPorId() throws Exception {
        FuncionarioDTO f = FuncionarioDTO.builder().id(1L).nome("Mauro").cargo("Dev").build();
        when(funcionarioService.buscarPorId(1L)).thenReturn(f);

        mockMvc.perform(get("/funcionarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void deveAtualizarFuncionario() throws Exception {
        FuncionarioDTO entrada = FuncionarioDTO.builder().nome("Mauro").cargo("Analista").build();
        FuncionarioDTO saida = FuncionarioDTO.builder().id(1L).nome("Mauro").cargo("Analista").build();
        when(funcionarioService.atualizar(any(Long.class), any(FuncionarioDTO.class))).thenReturn(saida);

        mockMvc.perform(put("/funcionarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cargo").value("Analista"));
    }

    @Test
    void deveExcluirFuncionario() throws Exception {
        doNothing().when(funcionarioService).deletar(1L);

        mockMvc.perform(delete("/funcionarios/1"))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }

    @Test
    void deveRetornar400QuandoDadosInvalidos() throws Exception {
        String bodyInvalido = """
                {"nome":"","cargo":""}
                """;

        mockMvc.perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensagem").value("Dados invalidos"));
    }
}
