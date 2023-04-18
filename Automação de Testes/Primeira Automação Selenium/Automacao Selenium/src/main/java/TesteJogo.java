import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteJogo {

    private static final String URL = "https://rachacuca.com.br/logica/problemas/show-de-talentos/";

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }

    @Test
    public void selecionarBasquete() {
        clicarValor("//*[@id=\"game\"]/div[1]/div[5]/ul/li[6]/select", "0");
    }

    @Test
    public void selecionarCorridaCandidato5() {
        clicarValor("//*[@id=\"game\"]/div[1]/div[6]/ul/li[6]/select", "2");
    }

    @Test
    public void selecionarCorridaCandidato() {
        clicarValor("//*[@id=\"game\"]/div[1]/div[2]/ul/li[1]/select ", "1");
    }

    private void clicarValor(String xpath, String valor) {
        WebElement elementBasquete = driver.findElement(By.xpath(xpath));
        Select selectBasquete = new Select(elementBasquete);

        selectBasquete.selectByValue(valor);
    }

}
