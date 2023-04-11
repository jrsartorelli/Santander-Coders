import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinhaPrimeiraAutomacao {

    private static final String URL = "https://google.com.br";
    private WebDriver driver;

    @BeforeEach
    public void begoreEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void teste_google_chrome() {

        driver.get(URL);

        assertEquals("Google", driver.getTitle());
    }

    @Test
    public void teste_google_edge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.get(URL);

        assertEquals("Google", driver.getTitle());
    }

    @Test
    public void teste_google_firefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get(URL);

        assertEquals("Google", driver.getTitle());
    }

    @Test
    public void teste_google_chrome_janela() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(URL);

        driver.manage().window().setPosition(new Point(500, 500));
        driver.manage().window().minimize();
    }
}
