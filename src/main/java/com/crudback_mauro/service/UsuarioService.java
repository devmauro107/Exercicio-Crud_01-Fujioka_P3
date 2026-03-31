package com.crudback_mauro.service;

import com.crudback_mauro.dto.UsuarioDTO;
import com.crudback_mauro.mapper.UsuarioMapper;
import com.crudback_mauro.model.Usuario;
import com.crudback_mauro.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        Usuario usuarioParaSalvar = usuarioMapper.toEntity(dto);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaSalvar);
        return usuarioMapper.toDTO(usuarioSalvo);
    }
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper :: toDTO)
                .toList();
    }

    @Transactional
    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado! " + id));
            usuario.setNomeCompleto(dto.getNomeCompleto());
            usuario.setEmail(dto.getEmail());
            usuario.setCpfCnpj(dto.getCpfCnpj());
            usuario.setDataNascimento(dto.getDataNascimento());
            usuario.setPerfil(dto.getPerfil());
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioAtualizado);
    }

    @Transactional
    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado! " + id));

        usuarioRepository.delete(usuario);
    }
}
