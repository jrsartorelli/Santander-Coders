import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitImplicitoTest {

    private static final String URL = "https://igorsmasc.github.io/praticando_waits/";

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

        WebElement elementParagrafo = driver.findElement(By.xpath("/html/body/p"));

        assertEquals("Este é um novo parágrafo adicionado após 3 segundos.",
                elementParagrafo.getText());

    }

}
