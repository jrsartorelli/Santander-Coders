import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitExplicitoTest {

    private static final String URL = "https://igorsmasc.github.io/praticando_waits/";
    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void botaoParagrafoTest() {
        WebElement botaoParagrafo =  driver.findElement(By.id("botao-paragrafo"));
        botaoParagrafo.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/p")));

        WebElement elementParagrafo = driver.findElement(By.xpath("/html/body/p"));

        assertEquals("Este é um novo parágrafo adicionado após 3 segundos.",
                elementParagrafo.getText());

    }
}
