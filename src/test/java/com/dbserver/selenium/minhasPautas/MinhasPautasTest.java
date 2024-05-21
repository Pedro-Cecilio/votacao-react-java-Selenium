package com.dbserver.selenium.minhasPautas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.Duration;
import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.actions.MinhasPautasActions;
import com.dbserver.selenium.paginaBase.BasePage;

@SpringBootTest
class MinhasPautasTest {
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
        void dadoEstouLogadoComoAdminQuandoAcessoMinhasPautasETentoCriarPautaCorretamenteDeveCriarNovaPauta() {
                MinhasPautasActions minhasPautas = this.loginActions
                                .logarComoAdmin()
                                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                                .clicarEmMinhasPautas()
                                .criarNovaPautaCorretamente();

                assertDoesNotThrow(
                                () -> minhasPautas.obterElementoPorTexto("Pauta criada com sucesso!",
                                                Duration.ofSeconds(10)));
        }

        @Test
        void dadoEstouLogadoComoAdminQuandoAcessoMinhasPautasETentoCriarPautaAssuntoVazioDeveRetornarMensagemDeErro() {
                MinhasPautasActions minhasPautas = this.loginActions
                                .logarComoAdmin()
                                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                                .clicarEmMinhasPautas()
                                .criarNovaPautaAssuntoVazio();

                assertDoesNotThrow(
                                () -> minhasPautas.obterElementoPorTexto("Assunto deve ser informado.",
                                                Duration.ofSeconds(10)));
        }

        @Test
        void dadoEstouLogadoComoAdminQuandoAcessoMinhasPautasETentoCriarPautaCategoriaVaziaDeveRetornarMensagemDeErro() {
                MinhasPautasActions minhasPautas = this.loginActions
                                .logarComoAdmin()
                                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                                .clicarEmMinhasPautas()
                                .criarNovaPautaCategoriaVazia();

                assertDoesNotThrow(
                                () -> minhasPautas.obterElementoPorTexto("Categoria deve ser informada.",
                                                Duration.ofSeconds(10)));
        }

        @Test
        void dadoEstouLogadoComoAdminQuandoTentoAbrirSessaoVotacaoEmNovaPautaCorretamenteDeveAbrirSessaoVotacao() {
                MinhasPautasActions minhasPautas = this.loginActions
                                .logarComoAdmin()
                                .esperarUrlSer(BasePage.URL_EXPLORAR, Duration.ofSeconds(10))
                                .clicarEmMinhasPautas()
                                .criarNovaPautaCorretamente();

                assertDoesNotThrow(() -> minhasPautas.obterElementoPorTexto("Pauta criada com sucesso!",
                                Duration.ofSeconds(10)));
                assertDoesNotThrow(() -> minhasPautas.abrirSessaoVotacaoCorretamente());
                assertDoesNotThrow(() -> minhasPautas.obterElementoPorDataTestId("popover-card-votacao-1",
                                Duration.ofSeconds(10)));
        }
}
