package com.dbserver.selenium.login;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.paginaBase.BasePage;

@SpringBootTest
class LoginTest {

    private LoginActions loginActions;

    @BeforeEach
    public void configurar() {
        this.loginActions = new LoginActions();
    }

    @AfterEach
    void limpar() {
        this.loginActions.fecharNavegador();
    }

    @Test
    void dadoEstouNaPaginaDeLoginQuandoInsiroDadosCorretosEEnvioDeveLogarNaAplicacao() {
        this.loginActions.logarComoUsuario()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10));

        assertEquals(BasePage.URL_EXPLORAR, loginActions.obterUrlAtual());
    }

    @Test
    void dadoEstouNaPaginaDeLoginQuandoInsiroDadosNaoCadastradosNoBancoEEnvioDeveExibirMensagemDeErro() {
        this.loginActions.logarDadosIncorretos();

        assertDoesNotThrow(() -> this.loginActions.obterElementoPorTexto("Dados de login inválidos."));
    }

    @Test
    void dadoEstouNaPaginaDeLoginQuandoInsiroSenhaInvalidaEEnvioDeveExibirMensagemDeErro() {
        this.loginActions.logarSenhaInvalida();

        assertDoesNotThrow(() -> this.loginActions.obterElementoPorTexto("Senha deve conter no mínimo 8 caracteres."));
    }
    @Test
    void dadoEstouNaPaginaDeLoginQuandoInsiroEmailInvalidoEnvioDeveExibirMensagemDeErro() {
        this.loginActions.logarEmailInvalido();

        assertDoesNotThrow(() -> this.loginActions.obterElementoPorTexto("Email deve ter formato válido."));
    }
}
