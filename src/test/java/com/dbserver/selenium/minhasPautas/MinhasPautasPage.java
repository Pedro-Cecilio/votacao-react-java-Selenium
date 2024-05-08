package com.dbserver.selenium.minhasPautas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dbserver.selenium.actions.MinhasPautasActions;
import com.dbserver.selenium.paginaBase.BasePage;

public class MinhasPautasPage extends BasePage<MinhasPautasActions> {

    public MinhasPautasPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement obterBotaoAbrirModalNovaPauta() {
        return this.obterElementoPorDataTestId("botao-abrirModalNovaPauta");
    }

    public WebElement obterModalNovaPauta() {
        return this.obterElementoPorDataTestId("modal-nova-pauta");
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

    public WebElement obterBotaoFecharModalAbrirPauta() {
        return this.obterElementoPorDataTestId("fechar-modal-abrir-pauta");
    }
    
    public WebElement obterMenuCardPauta() {
        return this.obterElementoPorDataTestId("menu-card-pauta");
    }

    public WebElement obterMenuItemAbrirVotacao() {
        return this.obterElementoPorDataTestId("menuItem-abrir-votacao");
    }

    public WebElement obterInputMinutosSessaoVotacao() {
        return this.obterElementoPorDataTestId("input-minutos-sessao-votacao");
    }

    public WebElement obterBotaoAbrirSessaoVotacao() {
        return this.obterElementoPorDataTestId("botao-abrir-sessao-votacao");
    }
}
