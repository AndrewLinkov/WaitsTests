package rosAtom;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import rosAtom.base.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExplicityWaitTests extends BaseTest {
    @Test
    public void testOpenPage() {
        try {
            // Открытие страницы
            driver.get(baseUrl);

            // Явное ожидание, что заголовок страницы содержит "Росатом"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(driver -> driver.getTitle().contains("Росатом"));

            // Получение заголовка текущей страницы
            String pageTitle = driver.getTitle();
            // Проверка, что заголовок содержит ключевое слово
            assertTrue(pageTitle.contains("Росатом"),
                    "Заголовок страницы должен содержать строку 'Росатом'. Актуальный заголовок: " + pageTitle);

        } catch (Exception e) {
            throw new AssertionError("Test failed: " + e.getMessage(), e);
        }
    }
}
