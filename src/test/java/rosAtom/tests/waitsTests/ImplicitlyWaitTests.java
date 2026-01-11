package rosAtom.tests.waitsTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import rosAtom.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplicitlyWaitTests extends BaseTest {

    @Test
    @DisplayName("Проверка раздела 'Журналистам'. Используем неявные ожидания ImplicitlyWait.")
    public void openPageJournalistsImplicitlyWaitTest() {
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
            throw new AssertionError("Ошибка: " + e.getMessage(), e);
        }
    }
}
