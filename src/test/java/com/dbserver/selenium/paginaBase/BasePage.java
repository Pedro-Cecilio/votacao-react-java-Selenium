package com.dbserver.selenium.paginaBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dbserver.selenium.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage<T extends BasePage<T>> {

    public static final String URL_BASE = "http://localhost:5173/";
    public static final String URL_EXPLORAR = URL_BASE + "explorar";
    public static final String URL_CADASTRO = URL_BASE + "cadastro";
    public static final String URL_MINHAS_PAUTAS = URL_BASE + "minhasPautas";

    protected WebDriver navegador;

    public BasePage() {
        WebDriverManager.chromedriver().setup();
        this.navegador = new ChromeDriver();
    }

    protected BasePage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public WebElement obterElementoPorDataTestId(String testId) {
        return this.navegador.findElement(Utils.byDataTestId(testId));
    }

    public WebElement obterElementoPorDataTestId(String testId, WebElement elemento) {
        return elemento.findElement(Utils.byDataTestId(testId));
    }

    public WebElement obterElementoPorDataTestId(String testId, Duration tempoDeEspera) {
        WebDriverWait wait = new WebDriverWait(navegador, tempoDeEspera);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(Utils.byDataTestId(testId)));
    }

    public WebElement obterElementoPorId(String id) {
        return this.navegador.findElement(By.id(id));
    }

    public WebElement obterElementoPorTexto(String texto) {
        return this.navegador.findElement(By.xpath("(//*[text()='%s'])[1]".formatted(texto)));
    }

    public WebElement obterElementoPorTexto(String texto, Duration tempoDeEspera) {
        WebDriverWait wait = new WebDriverWait(navegador, tempoDeEspera);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='%s'])[1]".formatted(texto))));
    }

    public String obterUrlAtual() {
        return this.navegador.getCurrentUrl();
    }

    @SuppressWarnings("unchecked")
    public T esperarUrlSer(String url, Duration tempoDeEspera) {
        WebDriverWait wait = new WebDriverWait(navegador, tempoDeEspera);
        wait.until(ExpectedConditions.urlToBe(url));
        return (T) this;
    }

    public void fecharNavegador() {
        this.navegador.quit();
    }
}
