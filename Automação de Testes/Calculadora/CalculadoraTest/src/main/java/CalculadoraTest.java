import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private static final String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";

    private static WebDriver driver;

    private static WebElement[] numeros;
    private static WebElement operacaoSoma;
    private static WebElement operacaoSubtracao;
    private static WebElement operacaoMultiplicacao;
    private static WebElement operacaoDivisao;
    private static WebElement operacaoIgual;
    private static WebElement operacaoLimpar;
    private static WebElement display;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);

        numeros = new WebElement[] {
                driver.findElement(By.id("zero")),
                driver.findElement(By.id("one")),
                driver.findElement(By.id("two")),
                driver.findElement(By.id("three")),
                driver.findElement(By.id("four")),
                driver.findElement(By.id("five")),
                driver.findElement(By.id("six")),
                driver.findElement(By.id("seven")),
                driver.findElement(By.id("eight")),
                driver.findElement(By.id("nine"))};

        operacaoSoma = driver.findElement(By.xpath("//*[@id=\"add\"]")); //XPATH
        operacaoSubtracao = driver.findElement(By.id("subtract")); //ID
        operacaoMultiplicacao = driver.findElement(By.id("multiply"));
        operacaoDivisao = driver.findElement(By.id("divide"));
        operacaoIgual = driver.findElement(By.id("equals"));
        operacaoLimpar = driver.findElement(By.id("clear"));
        display = driver.findElement(By.className("form-control")); //CLASSNAME
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void testarSomaLimpandoDisplay() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int valorOperacao = i + j;

                operacaoLimpar.click();
                numeros[i].click();
                operacaoSoma.click();
                numeros[j].click();
                operacaoIgual.click();

                String valorDisplay = display.getAttribute("value");

                assertEquals(String.valueOf(valorOperacao), valorDisplay);
            }
        }
    }

    @Test
    public void testarSomaSemLimparDisplay() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int valorOperacao = i + j;

                //operacaoLimpar.click();
                numeros[i].click();
                operacaoSoma.click();
                numeros[j].click();
                operacaoIgual.click();

                String valorDisplay = display.getAttribute("value");

                assertEquals(String.valueOf(valorOperacao), valorDisplay);
            }
        }
    }

    @Test
    public void testarSubtracaoLimpandoDisplay() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int valorOperacao = i - j;

                operacaoLimpar.click();
                numeros[i].click();
                operacaoSubtracao.click();
                numeros[j].click();
                operacaoIgual.click();

                String valorDisplay = display.getAttribute("value");

                assertEquals(String.valueOf(valorOperacao), valorDisplay);
            }
        }
    }

    @Test
    public void testarMultiplicacaoLimpandoDisplay() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int valorOperacao = i * j;

                operacaoLimpar.click();
                numeros[i].click();
                operacaoMultiplicacao.click();
                numeros[j].click();
                operacaoIgual.click();

                String valorDisplay = display.getAttribute("value");

                assertEquals(String.valueOf(valorOperacao), valorDisplay);
            }
        }
    }

    @Test
    public void testarDivisaoLimpandoDisplay() {

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                float valorOperacao = (float) i / j;

                operacaoLimpar.click();
                numeros[i].click();
                operacaoDivisao.click();
                numeros[j].click();
                operacaoIgual.click();

                String valorDisplay = display.getAttribute("value");

                assertEquals(valorOperacao, Float.valueOf(valorDisplay));
            }
        }
    }

    @Test
    public void testarDivisaoZeroPorZero() {

        operacaoLimpar.click();
        numeros[0].click();
        operacaoDivisao.click();
        numeros[0].click();
        operacaoIgual.click();

        assertEquals("NaN", display.getAttribute("value"));
    }

    @Test
    public void testarDivisaoNumeroPorZero() {

        for (int i = 1; i < 10; i++) {

            operacaoLimpar.click();
            numeros[i].click();
            operacaoDivisao.click();
            numeros[0].click();
            operacaoIgual.click();

            assertEquals("Infinity", display.getAttribute("value"));
        }
    }
}
