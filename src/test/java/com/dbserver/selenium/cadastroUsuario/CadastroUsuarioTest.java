package com.dbserver.selenium.cadastroUsuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.Duration;

import com.dbserver.selenium.actions.CadastroUsuarioActions;
import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.paginaBase.BasePage;

@SpringBootTest
class CadastroUsuarioTest {

    private LoginActions loginActions;

    @BeforeEach
    void configurar() {
        this.loginActions = new LoginActions();
    }

    @Test
    void dadoEstouLogadoComoAdminTentoCadastrarUsuarioComDadosValidosDeveCadastrarCorretamente() {
        CadastroUsuarioActions cadastroUsuario = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmNovoUsuario()
                .esperarUrlSer(BasePage.URL_CADASTRO, Duration.ofSeconds(10))
                .cadastrarUsuarioCorretamente();

        assertDoesNotThrow(() -> cadastroUsuario.obterElementoPorTexto("Usuário criado com sucesso", Duration.ofSeconds(5)));
    }

    @Test
    void dadoEstouLogadoComoAdminQuandoTentoCadastrarUsuarioComEmailJaCadastradoDeveRetornarMensagemDeErro() {
        CadastroUsuarioActions cadastroUsuario = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmNovoUsuario()
                .esperarUrlSer(BasePage.URL_CADASTRO, Duration.ofSeconds(10))
                .cadastrarUsuarioComEmailExistente();

        assertDoesNotThrow(() -> cadastroUsuario.obterElementoPorTexto("Email já cadastrado.", Duration.ofSeconds(5)));
    }
    @Test
    void dadoEstouLogadoComoAdminQuandoTentoCadastrarUsuarioComCpfJaCadastradoDeveRetornarMensagemDeErro() {
        CadastroUsuarioActions cadastroUsuario = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmNovoUsuario()
                .esperarUrlSer(BasePage.URL_CADASTRO, Duration.ofSeconds(10))
                .cadastrarUsuarioComCpfExistente();

        assertDoesNotThrow(() -> cadastroUsuario.obterElementoPorTexto("Cpf já cadastrado.", Duration.ofSeconds(5)));
    }
}
