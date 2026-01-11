package rosAtom.tests.waitsTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rosAtom.BaseTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ExpectedConditionsUITests extends BaseTest {

    @Test
    @DisplayName("Проверка раздела 'Журналистам'. Используем явные ожидания ExpectedConditions.")
    public void testPageTitleContainsRosatom() {

        try {
            // Ожидание и проверка заголовка
            //wait.until(ExpectedConditions.titleContains("Росатом"));
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
            throw new AssertionError("Ошибка: " + e.getMessage(), e);
        }
    }
}
