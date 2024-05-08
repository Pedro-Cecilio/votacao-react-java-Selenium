package com.dbserver.selenium.explorar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;

import com.dbserver.selenium.actions.ExplorarActions;
import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.actions.MinhasPautasActions;
import com.dbserver.selenium.paginaBase.BasePage;

@SpringBootTest
class ExplorarTest {
    private LoginActions loginActions;

    @BeforeEach
    void configurar() {
        this.loginActions = new LoginActions();
    }

    @AfterEach
    void limpar() {
    this.loginActions.fecharNavegador();
    }

    @Test
    void dadoEstouLogadoComoAdminQuandoAcessoExplorarWhenVerificarComponentesDoHeader() {
        ExplorarActions explorar = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10));

        assertDoesNotThrow(() -> explorar.obterLinkExplorar());
        assertDoesNotThrow(() -> explorar.obterLinkNovoUsuario());
        assertDoesNotThrow(() -> explorar.obterLinkMinhasPautas());
        assertDoesNotThrow(() -> explorar.obterLinkSair());
    }

    @Test
    void dadoEstouLogadoComoUsuarioQuandoAcessoExplorarWhenVerificarComponentesDoHeader() {
        ExplorarActions explorar = this.loginActions
                .logarComoUsuario()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10));

        assertDoesNotThrow(() -> explorar.obterLinkExplorar());
        assertThrows(NoSuchElementException.class, () -> explorar.obterLinkNovoUsuario());
        assertThrows(NoSuchElementException.class, () -> explorar.obterLinkMinhasPautas());
        assertDoesNotThrow(() -> explorar.obterLinkSair());
    }

    @Test
    void dadoEstouLogadoComoUsuarioQuandoTentoVotarEmUmaPautaWhenRetornarMensagemDeSucesso() {
        MinhasPautasActions minhasPautas = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmMinhasPautas()
                .criarNovaPautaCorretamente();

        minhasPautas.obterElementoPorTexto("Pauta criada com sucesso!", Duration.ofSeconds(10));
        minhasPautas
                .abrirSessaoVotacaoCorretamente();

        LoginActions novaPagina = new LoginActions();
        novaPagina
                .logarComoUsuario()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .votarPositivoNaUltimaPautaAberta();
        assertDoesNotThrow(() -> novaPagina.obterElementoPorTexto("Voto inserido com sucesso", Duration.ofSeconds(10)));
        novaPagina.fecharNavegador();
    }

    @Test
    void dadoEstouLogadoComoUsuarioQuandoTentoVotarDuasVezesEmUmaPautaWhenRetornarMensagemDeErro() {
        MinhasPautasActions minhasPautas = this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmMinhasPautas()
                .criarNovaPautaCorretamente();

        minhasPautas.obterElementoPorTexto("Pauta criada com sucesso!", Duration.ofSeconds(10));
        minhasPautas
                .abrirSessaoVotacaoCorretamente();

        LoginActions novaPagina = new LoginActions();
        novaPagina
                .logarComoUsuario()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .votarPositivoNaUltimaPautaAberta()
                .votarPositivoNaUltimaPautaAberta();
        assertDoesNotThrow(
                () -> novaPagina.obterElementoPorTexto("Não é possível votar duas vezes.", Duration.ofSeconds(10)));
        novaPagina.fecharNavegador();
    }
}
