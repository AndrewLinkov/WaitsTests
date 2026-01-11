package rosAtom.tests.waitsTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import rosAtom.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExplicityWaitTests extends BaseTest {

    private final By buttonJournalists = By.xpath("//li/a[@href=\"/journalist/\"]");

    @Test
    @DisplayName("Проверка раздела 'Журналистам'. Используем явные ожидания ExplicityWait.")
    public void openPageJournalistsExplicityWaitTest() {

        try {
            // Использование явного ожидания
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(driver -> driver.getTitle().contains("Росатом"));

            // Переход на вкладку 'Журналистам'
            driver.findElement(buttonJournalists).click();

            // Сценарий если страница медленно грузится
            wait.until(driver -> driver.findElement(By.xpath("//h2[contains(text(),'Форма обратной связи')]")).isDisplayed());

            // Проверка отображения заголовка 'Форма обратной связи'
            String feedbackFormTitle = driver.findElement(By.xpath("//h2[contains(text(),'Форма обратной связи')]")).getText();
            assertTrue(feedbackFormTitle.contains("Форма обратной связи"),
                "На странице должен отображаться заголовок 'Форма обратной связи'");

        } catch (Exception e) {
            throw new AssertionError("Ошибка: " + e.getMessage(), e);
        }
    }
}
