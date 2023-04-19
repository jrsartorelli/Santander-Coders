import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        driver.quit();
    }

    @Test
    public void criarRegistro1Test() {
        WebElement inputNome = driver.findElement(By.id("nome"));
        WebElement inputSobrenome = driver.findElement(By.id("sobrenome"));
        WebElement radioMasculino = driver.findElement(By.id("masculino"));
        WebElement radioFeminino = driver.findElement(By.id("feminino"));
        WebElement radioOutro = driver.findElement(By.id("outro"));
        WebElement checkboxJava = driver.findElement(By.id("java"));
        WebElement checkboxSelenium = driver.findElement(By.id("selenium"));
        WebElement checkboxJunit = driver.findElement(By.id("junit"));
        WebElement checkboxJavaScript = driver.findElement(By.id("javascript"));
        WebElement elementSelectMultipleAreaInteresse = driver.findElement(By.id("area-interesse"));
        Select selectMultipleAreaInteresse = new Select(elementSelectMultipleAreaInteresse);
        WebElement elementSelectMotivacao = driver.findElement(By.id("motivacao"));
        Select SelectMotivacao = new Select(elementSelectMotivacao);
        WebElement textAreaPorque = driver.findElement(By.id("porque"));
        WebElement botaoEnviar = driver.findElement(By.xpath("//*[@id=\"formulario\"]/div[8]/button[2]"));

        inputNome.sendKeys("Maria");
        inputSobrenome.sendKeys("Silva");
        radioFeminino.click();
        checkboxJava.click();
        checkboxJavaScript.click();
        selectMultipleAreaInteresse.selectByVisibleText("Backend");
        selectMultipleAreaInteresse.selectByVisibleText("Testes");
        SelectMotivacao.selectByValue("Testes");
        textAreaPorque.sendKeys("Combina com meu perfil");

        assertEquals("Maria", inputNome.getAttribute("value"));
        assertEquals("Silva", inputSobrenome.getAttribute("value"));
        assertFalse(radioMasculino.isSelected());
        assertTrue(radioFeminino.isSelected());
        assertFalse(radioOutro.isSelected());
        assertTrue(checkboxJava.isSelected());
        assertFalse(checkboxSelenium.isSelected());
        assertFalse(checkboxJunit.isSelected());
        assertTrue(checkboxJavaScript.isSelected());
        List<WebElement> selectedOptions = selectMultipleAreaInteresse.getAllSelectedOptions();
        List<String> selectedValues  = selectedOptions.stream().map(WebElement::getText).toList();
        String[] valoresEsperados = {"Backend", "Testes"};
        assertArrayEquals(valoresEsperados, selectedValues.toArray());
        assertEquals("Testes", SelectMotivacao.getFirstSelectedOption().getText());
        assertEquals("Combina com meu perfil", textAreaPorque.getAttribute("value"));

        botaoEnviar.click();

        driver.switchTo().alert().accept();

        WebElement elementRegistro = driver.findElement(By.id("table-cadastros-body"));

        assertEquals("Maria Silva feminino Backend, Testes Testes", elementRegistro.getText());
    }
}
