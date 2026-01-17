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

        // Установка таймаутов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(baseUrl);

        // Ждем загрузки страницы (проверяем, что title не пустой)
        wait.until(driver -> !driver.getTitle().isEmpty());
        String pageTitle = driver.getTitle();

        // Выводим полный заголовок для отладки
        assertTrue(pageTitle.contains("Росатом"),
                "Заголовок страницы должен содержать 'Росатом'. Актуальный заголовок: " + pageTitle);
    }
}
