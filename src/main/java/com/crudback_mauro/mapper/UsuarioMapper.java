package com.crudback_mauro.mapper;

import com.crudback_mauro.dto.UsuarioDTO;
import com.crudback_mauro.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        return Usuario.builder()
                .id(dto.getId())
                .nomeCompleto(dto.getNomeCompleto())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .cpfCnpj(dto.getCpfCnpj())
                .dataNascimento(dto.getDataNascimento())
                .perfil(dto.getPerfil())
                .build();
    }

    public UsuarioDTO toDTO(Usuario entity) {
        if  (entity == null) return null;

        return UsuarioDTO.builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .email(entity.getEmail())
                .cpfCnpj(entity.getCpfCnpj())
                .dataNascimento(entity.getDataNascimento())
                .perfil(entity.getPerfil())
                .build();
    }
}
