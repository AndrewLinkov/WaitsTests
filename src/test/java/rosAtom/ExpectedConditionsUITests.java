package rosAtom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rosAtom.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Тесты с использованием явных ожиданий (Explicit Waits)
 */
public class ExpectedConditionsUITests extends BaseTest {


    @Test
    @DisplayName("Проверка загрузки главной страницы Росатома")
    public void testPageTitleContainsRosatom() {
        // Открытие страницы
        driver.get(baseUrl);

        try {
            // Ожидание и проверка заголовка
            wait.until(ExpectedConditions.titleContains("Росатом"));
            String actualTitle = driver.getTitle();

            // Проверки
            assertAll(
                () -> assertTrue(actualTitle.contains("Росатом"),
                    String.format("Заголовок страницы должен содержать 'Росатом'. Актуальный заголовок: %s", actualTitle)),
                () -> assertTrue(driver.getCurrentUrl().startsWith(baseUrl),
                    String.format("Текущий URL должен начинаться с %s. Актуальный URL: %s",
                        baseUrl, driver.getCurrentUrl()))
            );

        } catch (Exception e) {
            fail("Ошибка при выполнении теста: " + e.getMessage(), e);
        }
    }
}
