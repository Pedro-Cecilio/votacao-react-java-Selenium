package com.dbserver.selenium.fixture;

import java.util.Locale;

import com.dbserver.selenium.models.DadosLogin;

import net.datafaker.Faker;

public class LoginFixture {
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    private static final String EMAIL_ADMIN_VALIDO = "testesAdmin@email.com";
    private static final String SENHA_ADMIN_VALIDA = "testes123";
    private static final String EMAIL_USUARIO_VALIDO = "testesUsuario@email.com";
    private static final String SENHA_USUARIO_VALIDA = "testes123";
    private static final String EMAIL_ADMIN_INVALIDO = "emailInvalido";
    private static final String SENHA_ADMIN_INVALIDA = "invalid";

    public static DadosLogin dadosLoginAdminValidos() {
        return DadosLogin.builder()
                .email(EMAIL_ADMIN_VALIDO)
                .senha(SENHA_ADMIN_VALIDA)
                .build();
    }
    public static DadosLogin dadosLoginUsuarioValidos() {
        return DadosLogin.builder()
                .email(EMAIL_USUARIO_VALIDO)
                .senha(SENHA_USUARIO_VALIDA)
                .build();
    }

    public static DadosLogin dadosLoginNaoCadastrado() {
        return DadosLogin.builder()
                .email(faker.internet().emailAddress())
                .senha(faker.number().digits(8))
                .build();
    }

    public static DadosLogin dadosLoginEmailFormatoInvalido() {
        return DadosLogin.builder()
                .email(EMAIL_ADMIN_INVALIDO)
                .senha(faker.number().digits(8))
                .build();
    }

    public static DadosLogin dadosLoginSenhaFormatoInvalido() {
        return DadosLogin.builder()
                .email(EMAIL_ADMIN_VALIDO)
                .senha(SENHA_ADMIN_INVALIDA)
                .build();
    }
}
