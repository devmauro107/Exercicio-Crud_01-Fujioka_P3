package com.crudback_mauro.service;

import com.crudback_mauro.dto.FuncionarioDTO;
import com.crudback_mauro.mapper.FuncionarioMapper;
import com.crudback_mauro.model.Funcionario;
import com.crudback_mauro.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional
    public FuncionarioDTO incluir(FuncionarioDTO funcionarioDTO) {
        Funcionario salvo = funcionarioRepository.save(FuncionarioMapper.toEntity(funcionarioDTO));
        return FuncionarioMapper.toDTO(salvo);
    }

    public List<FuncionarioDTO> listar() {
        return funcionarioRepository.findAllByOrderByNomeAsc()
                .stream()
                .map(FuncionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorId(Long id) {
        return FuncionarioMapper.toDTO(buscarEntidadePorId(id));
    }

    @Transactional
    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioAtualizado) {
        Funcionario existente = buscarEntidadePorId(id);
        FuncionarioMapper.updateEntityFromDTO(funcionarioAtualizado, existente);
        return FuncionarioMapper.toDTO(funcionarioRepository.save(existente));
    }

    @Transactional
    public void deletar(Long id) {
        Funcionario existente = buscarEntidadePorId(id);
        funcionarioRepository.delete(existente);
    }

    private Funcionario buscarEntidadePorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado pelo ID: " + id));
    }
}
