import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoLocators {

    private static final String URL = "https://igorsmasc.github.io/praticando_locators_selenium/";

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test //01
    public void locatorById() {
        WebElement element = driver.findElement(By.id("locator-id"));
        Assertions.assertEquals("Achei com ID", element.getText());
    }

    @Test //02
    public void locatorByClass() {
        WebElement element = driver.findElement(By.className("locator-class-name"));
        Assertions.assertEquals("Achei com Class Name", element.getText());
    }

    @Test //03
    public void locatorByName() {
        WebElement element = driver.findElement(By.name("locator-name"));
        Assertions.assertEquals("Achei com Name", element.getText());
    }

    @Test //04
    public void locatorByCSSSelector() {
        WebElement element = driver.findElement(By.cssSelector(".css-selector-locator"));
        Assertions.assertEquals("Achei com CSS Selector", element.getText());
    }

    @Test //05
    public void locatorByLinkText() {
        WebElement element = driver.findElement(By.linkText("Achei com o link text"));
        Assertions.assertEquals("https://www.google.com/", element.getAttribute("href"));
    }

    @Test //06
    public void locatorByPartialLink() {
        WebElement element = driver.findElement(By.partialLinkText("Achei com o partial"));
        Assertions.assertEquals("https://github.com/", element.getAttribute("href"));
    }

    @Test //07
    public void locatorByTagName() {
        WebElement element = driver.findElement(By.tagName("details"));
        Assertions.assertEquals("Achei com Tag Name", element.getText());
    }

    @Test //08
    public void locatorByXPath() {
        WebElement element = driver.findElement(By.xpath("//p[@id='locator-xpath']"));
        Assertions.assertEquals("Achei com o XPATH", element.getText());
    }
}
