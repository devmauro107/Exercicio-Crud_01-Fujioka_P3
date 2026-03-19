package com.crudback_mauro.mapper;

import com.crudback_mauro.dto.FuncionarioDTO;
import com.crudback_mauro.model.Funcionario;

public class FuncionarioMapper {

    private FuncionarioMapper() {
    }

    public static FuncionarioDTO toDTO(Funcionario funcionario) {
        if (funcionario == null) return null;
        return FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .cargo(funcionario.getCargo())
                .build();
    }

    public static Funcionario toEntity(FuncionarioDTO dto) {
        if (dto == null) return null;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setCargo(dto.getCargo());
        return funcionario;
    }

    public static void updateEntityFromDTO(FuncionarioDTO dto, Funcionario entity) {
        if (dto == null || entity == null) return;
        entity.setNome(dto.getNome());
        entity.setCargo(dto.getCargo());
    }
}
