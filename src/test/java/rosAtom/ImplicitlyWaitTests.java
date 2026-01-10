package rosAtom;

import org.junit.jupiter.api.Test;
import rosAtom.base.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplicitlyWaitTests extends BaseTest {
    @Test
    public void testOpenPage() {
        try {
            // Открытие страницы
            driver.get(baseUrl);

            // Установка неявного ожидания (Implicit Wait)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
