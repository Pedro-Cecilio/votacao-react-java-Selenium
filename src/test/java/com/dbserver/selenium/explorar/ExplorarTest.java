package com.dbserver.selenium.explorar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Duration;
import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.paginaBase.BasePage;

@SpringBootTest
class ExplorarTest {
    private LoginActions loginActions;

    @BeforeEach
    void configurar() {
        this.loginActions = new LoginActions();
    }

    @Test
    void dadoEstouLogadoComoAdminQuandoAcessoExplorarWhenVerificarComponentesDoHeader() {
        this.loginActions
                .logarComoAdmin()
                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                .clicarEmNovoUsuario();
        // ExplorarPage explorarPage = new ExplorarPage()
    }
}
