import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroCandidadosTest {

    private static final String URL = "https://igorsmasc.github.io/fomulario_cadastro_selenium/";

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }

    @Test
    public void registro1() {
        WebElement campoTexto = driver.findElement(By.id("campoTexto"));
        campoTexto.sendKeys("Maria");

        WebElement campoSenha = driver.findElement(By.id("campoSenha"));
        campoSenha.sendKeys("1234abcd");

        WebElement campoNumero = driver.findElement(By.id("campoNumero"));
        campoNumero.sendKeys("1234567890");

        WebElement campoTextoLongo = driver.findElement(By.id("campoTextoLongo"));
        campoTextoLongo.sendKeys("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
    }
}
