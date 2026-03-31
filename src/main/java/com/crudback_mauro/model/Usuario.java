package com.crudback_mauro.model;

import com.crudback_mauro.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nomeCompleto;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 254, unique = true)
    private String email;

    @Column(nullable = false, length = 60)
    private String senha;

    @Column(nullable = false, length = 14, unique = true)
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Perfil perfil;

    @org.springframework.data.annotation.CreatedDate
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @org.springframework.data.annotation.LastModifiedDate
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
