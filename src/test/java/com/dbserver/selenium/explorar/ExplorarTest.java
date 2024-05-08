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
}
