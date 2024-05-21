package com.dbserver.selenium.minhasPautas;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dbserver.selenium.actions.MinhasPautasActions;
import com.dbserver.selenium.paginaBase.BasePage;

public class MinhasPautasPage extends BasePage<MinhasPautasActions> {

    public MinhasPautasPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement obterBotaoAbrirModalNovaPauta() {
        return this.obterElementoPorDataTestId("botao-abrirModalNovaPauta");
    }

    public WebElement obterInputAssuntoModalNovaPauta() {
        return this.obterElementoPorDataTestId("input-assunto");
    }

    public WebElement obterSelectCategoriaModalNovaPauta() {
        return this.obterElementoPorDataTestId("select-categoria");
    }

    public WebElement obterBotaoCriarPauta() {
        return this.obterElementoPorDataTestId("botao-criar-pauta");
    }

    public WebElement obterUltimaPautaCriada() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='lista-de-pautas'] > :first-child")));
    }

    public WebElement obterMenuCardPauta(WebElement elemento) {
        return this.obterElementoPorDataTestId("menu-card-pauta", elemento);
    }

    public WebElement obterMenuItemAbrirVotacao(WebElement elemento) {
        return this.obterElementoPorDataTestId("menuItem-abrir-votacao", elemento);
    }

    public WebElement obterInputMinutosSessaoVotacao() {
        return this.obterElementoPorDataTestId("input-minutos-sessao-votacao");
    }

    public WebElement obterBotaoAbrirSessaoVotacao() {
        return this.obterElementoPorDataTestId("botao-abrir-sessao-votacao");
    }

}
