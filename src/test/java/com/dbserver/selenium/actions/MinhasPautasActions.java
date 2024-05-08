package com.dbserver.selenium.actions;

import org.openqa.selenium.WebDriver;

import com.dbserver.selenium.fixture.NovaPautaFixture;
import com.dbserver.selenium.minhasPautas.MinhasPautasPage;
import com.dbserver.selenium.models.DadosNovaPauta;

public class MinhasPautasActions extends MinhasPautasPage {

    public MinhasPautasActions(WebDriver webDriver) {
        super(webDriver);
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

    // public MinhasPautasActions abrirSessaoVotacaoCorretamente(){
    //     this.criarNovaPautaCorretamente();
    //     this.
    // }
}
