package rosAtom.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import rosAtom.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplicitlyWaitTests extends BaseTest {

    @Test

    public void testOpenPage() {
        try {
            // Установка таймаутов
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get(baseUrl);
            
            // Ждем загрузки страницы (проверяем, что title не пустой)
            wait.until(driver -> !driver.getTitle().isEmpty());
            String pageTitle = driver.getTitle();
            
            // Проверка, что заголовок не пустой
            assertTrue(pageTitle != null && !pageTitle.isEmpty(), "Заголовок страницы пустой");
            
            // Выводим полный заголовок для отладки
            assertTrue(pageTitle.contains("Росатом"),
                    "Заголовок страницы должен содержать 'Росатом'. Актуальный заголовок: " + pageTitle);

        } catch (Exception e) {
            System.err.println("Ошибка при выполнении теста: " + e.getMessage());
            e.printStackTrace();
            throw new AssertionError("Test failed: " + e.getMessage(), e);
        }
    }
}
