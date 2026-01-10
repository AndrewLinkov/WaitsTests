package rosAtom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected final String baseUrl = "https://rosatom.ru/";

    @BeforeAll
    public static void setUp() {
        try {
            // Настройка драйвера для Firefox
            WebDriverManager.firefoxdriver().setup();

            // Настройка опций Firefox
            FirefoxOptions options = new FirefoxOptions();

            // Инициализация драйвера с настройками
            driver = new FirefoxDriver(options);

            // Максимизация окна браузера
            driver.manage().window().maximize();

            // Установка неявного ожидания
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Инициализация явного ожидания
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
