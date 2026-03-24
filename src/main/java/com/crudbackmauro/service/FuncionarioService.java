package com.crudbackmauro.service;

import com.crudbackmauro.dto.FuncionarioDTO;
import com.crudbackmauro.mapper.FuncionarioMapper;
import com.crudbackmauro.model.Funcionario;
import com.crudbackmauro.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

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

    public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioAtualizado) {
        Funcionario existente = buscarEntidadePorId(id);
        FuncionarioMapper.updateEntityFromDTO(funcionarioAtualizado, existente);
        return FuncionarioMapper.toDTO(funcionarioRepository.save(existente));
    }

    public void deletar(Long id) {
        Funcionario existente = buscarEntidadePorId(id);
        funcionarioRepository.delete(existente);
    }

    private Funcionario buscarEntidadePorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado pelo ID: " + id));
    }
}
