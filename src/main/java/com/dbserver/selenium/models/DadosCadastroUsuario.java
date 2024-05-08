package com.dbserver.selenium.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class DadosCadastroUsuario {
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String tipoDeUsuario;
}
