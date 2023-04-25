import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitExplicitoTest {

    private static final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void abrirAlert5Segundos() {
        WebElement botaoAlert =  driver.findElement(By.id("alert"));
        botaoAlert.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("I got opened after 5 secods", alert.getText());
        alert.accept();

    }

    @Test
    public void trocarTexto10Segundos() {
        WebElement botaoTrocarTexto =  driver.findElement(By.id("populate-text"));
        botaoTrocarTexto.click();

        wait.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));

        assertEquals("Selenium Webdriver", driver.findElement(By.id("h2")).getText());

    }

    @Test
    public void mostarBotao10Segundos() {
        WebElement botaoMostarOutroBotao =  driver.findElement(By.id("display-other-button"));
        botaoMostarOutroBotao.click();

        WebElement botaoEscondido = driver.findElement(By.id("hidden"));

        wait.until(ExpectedConditions.visibilityOf(botaoEscondido));

        assertTrue(botaoEscondido.isDisplayed());
        assertEquals("Enabled", botaoEscondido.getText());

    }

    @Test
    public void habilitarBotao10Segundos() {
        WebElement botaoHabilitaOutroBotao =  driver.findElement(By.id("enable-button"));
        botaoHabilitaOutroBotao.click();

        WebElement botaoDesabilitado = driver.findElement(By.id("disable"));

        wait.until(ExpectedConditions.elementToBeClickable(botaoDesabilitado));

        assertTrue(botaoDesabilitado.isEnabled());
    }

    @Test
    public void checkCheckbox10Segundos() {
        WebElement botaocheckCheckbox =  driver.findElement(By.id("checkbox"));
        botaocheckCheckbox.click();

        WebElement elementoCheckbox = driver.findElement(By.id("ch"));

        wait.until(ExpectedConditions.elementToBeSelected(elementoCheckbox));

        assertTrue(elementoCheckbox.isSelected());
    }
}
