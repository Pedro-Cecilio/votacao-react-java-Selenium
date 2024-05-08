package com.dbserver.selenium.fixture;

import java.util.Locale;

import com.dbserver.selenium.models.DadosCadastroUsuario;

import net.datafaker.Faker;

public class CadastroUsuarioFixture {
    private static final Faker faker = new Faker(new Locale("pt-BR"));
    private static final String EMAIL_EXISTENTE = "testesAdmin@email.com";
    private static final String CPF_EXISTENTE = "12345678911";
    private static final String TIPO_USUARIO = "USUARIO";
    
    public static DadosCadastroUsuario cadastroUsuarioValido() {
        return DadosCadastroUsuario.builder()
                .email(faker.internet().emailAddress())
                .senha(faker.number().digits(8))
                .nome(faker.name().firstName())
                .sobrenome(faker.name().lastName())
                .cpf(faker.number().digits(11))
                .tipoDeUsuario(TIPO_USUARIO)
                .build();
    }
    public static DadosCadastroUsuario cadastroUsuarioEmailExistente() {
        return DadosCadastroUsuario.builder()
                .email(EMAIL_EXISTENTE)
                .senha(faker.number().digits(8))
                .nome(faker.name().firstName())
                .sobrenome(faker.name().lastName())
                .cpf(faker.number().digits(11))
                .tipoDeUsuario(TIPO_USUARIO)
                .build();
    }
    public static DadosCadastroUsuario cadastroUsuarioCpfExistente() {
        return DadosCadastroUsuario.builder()
                .email(faker.internet().emailAddress())
                .senha(faker.number().digits(8))
                .nome(faker.name().firstName())
                .sobrenome(faker.name().lastName())
                .cpf(CPF_EXISTENTE)
                .tipoDeUsuario(TIPO_USUARIO)
                .build();
    }
}
