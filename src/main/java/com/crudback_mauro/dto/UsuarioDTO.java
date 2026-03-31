package com.crudback_mauro.dto;


import com.crudback_mauro.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "Nome obrigatório")
    private String nomeCompleto;

    @Email
    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "Senha obrigatória")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @NotBlank(message = "CPF/CNPJ obrigatório")
    private String cpfCnpj;

    private LocalDate dataNascimento;
    private Perfil perfil;
}
