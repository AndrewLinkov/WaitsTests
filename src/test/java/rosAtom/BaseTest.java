package rosAtom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    protected static WebDriver driver;
    protected static final String baseUrl = "https://rosatom.ru/";

    @BeforeAll
    public static void setUp() {
        try {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.get(baseUrl);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось инициализировать WebDriver: " + e.getMessage(), e);
        }
    }

    @AfterAll
    public static void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Ошибка при закрытии браузера: " + e.getMessage());
        }
    }
}
