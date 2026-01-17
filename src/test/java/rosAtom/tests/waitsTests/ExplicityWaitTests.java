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
    private final By feedbackFormTitle = By.xpath("//h2[contains(text(),'Форма обратной связи')]");

    @Test
    @DisplayName("Проверка раздела 'Журналистам'. Используем явные ожидания ExplicityWait.")
    public void openPageJournalistsExplicityWaitTest() {

        // Создаем объект класса WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // После вызова BaseUrl дожидаемся появления заголовка "Росатом" на странице
        wait.until(driver -> driver.getTitle().contains("Росатом"));

            /*
            // Альтернатива. Создается объект кнопка и проверяется видимость кнопки "Журналистам",
            // затем нажимается на эту кнопку
            WebElement button = wait.until(elementToBeClickable(buttonJournalists));
            button.click();
             */

        // Переход на вкладку 'Журналистам'
        driver.findElement(buttonJournalists).click();

        // Ожидаем true если после загрузки страницы появилась заголовок форма обратной связи
        boolean isFormDisplayed = wait.until(driver -> driver.findElement(feedbackFormTitle).isDisplayed());
        // Проверяем отображение формы обратной связи
        assertTrue(isFormDisplayed, "Форма обратной связи не отображается");
    }
}
