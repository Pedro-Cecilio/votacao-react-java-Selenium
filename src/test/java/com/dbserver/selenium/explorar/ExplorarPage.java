package com.dbserver.selenium.explorar;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dbserver.selenium.actions.ExplorarActions;
import com.dbserver.selenium.paginaBase.BasePage;

public class ExplorarPage extends BasePage<ExplorarActions>{
    
    public ExplorarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement obterLinkExplorar(){
        return this.obterElementoPorDataTestId("nav-explorar");
    }
    public WebElement obterLinkNovoUsuario(){
        return this.obterElementoPorDataTestId("nav-novo-usuario");
    }
    public WebElement obterLinkMinhasPautas(){
        return this.obterElementoPorDataTestId("nav-minhas-pautas");
    }
    public WebElement obterLinkSair(){
        return this.obterElementoPorDataTestId("nav-logout");
    }

    public WebElement obterUltimaPautaCriada() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='lista-de-pautas'] > :first-child")));
    }

    public WebElement obterBotaoVotoPositivoUltimaPauta() {
        WebElement pauta = obterUltimaPautaCriada();
        return this.obterElementoPorDataTestId("botao-voto-positivo", pauta);
    }
}
