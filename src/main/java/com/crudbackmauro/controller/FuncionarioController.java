package com.crudbackmauro.controller;

import com.crudbackmauro.dto.FuncionarioDTO;
import com.crudbackmauro.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping


    public ResponseEntity<FuncionarioDTO> incluir(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.incluir(funcionarioDTO));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listar() {
        return ResponseEntity.ok(funcionarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FuncionarioDTO funcionarioDTO
    ) {
        return ResponseEntity.ok(funcionarioService.atualizar(id, funcionarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
