package com.dbserver.selenium.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dbserver.selenium.fixture.NovaPautaFixture;
import com.dbserver.selenium.minhasPautas.MinhasPautasPage;
import com.dbserver.selenium.models.DadosNovaPauta;

public class MinhasPautasActions extends MinhasPautasPage {

    public MinhasPautasActions(WebDriver navegador) {
        super(navegador);
    }

    public MinhasPautasActions criarNovaPautaCorretamente() {
        DadosNovaPauta dados = NovaPautaFixture.criarNovaPautaCorretamente();
        this.obterBotaoAbrirModalNovaPauta().click();
        this.obterInputAssuntoModalNovaPauta().sendKeys(dados.getAssunto());
        this.obterSelectCategoriaModalNovaPauta().sendKeys(dados.getCategoria());
        this.obterBotaoCriarPauta().click();
        return this;
    }
    public MinhasPautasActions criarNovaPautaAssuntoVazio() {
        DadosNovaPauta dados = NovaPautaFixture.criarNovaPautaAssuntoVazio();
        this.obterBotaoAbrirModalNovaPauta().click();
        this.obterInputAssuntoModalNovaPauta().sendKeys(dados.getAssunto());
        this.obterSelectCategoriaModalNovaPauta().sendKeys(dados.getCategoria());
        this.obterBotaoCriarPauta().click();
        return this;
    }
    public MinhasPautasActions criarNovaPautaCategoriaVazia() {
        DadosNovaPauta dados = NovaPautaFixture.criarNovaPautaCategoriaVazia();
        this.obterBotaoAbrirModalNovaPauta().click();
        this.obterInputAssuntoModalNovaPauta().sendKeys(dados.getAssunto());
        this.obterSelectCategoriaModalNovaPauta().sendKeys(dados.getCategoria());
        this.obterBotaoCriarPauta().click();
        return this;
    }

    public MinhasPautasActions abrirSessaoVotacaoCorretamente(){
        WebElement cardPauta = this.obterUltimaPautaCriada();
        this.obterMenuCardPauta(cardPauta).click();
        this.obterMenuItemAbrirVotacao(cardPauta).click();
        this.obterInputMinutosSessaoVotacao().clear();
        this.obterInputMinutosSessaoVotacao().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.obterInputMinutosSessaoVotacao().sendKeys("5");
        this.obterBotaoAbrirSessaoVotacao().click();
        return this;
    }

    public ExplorarActions navegarParaExplorar(){
        this.navegador.navigate().to(URL_EXPLORAR);
        return new ExplorarActions(this.navegador);
    }

    
}
