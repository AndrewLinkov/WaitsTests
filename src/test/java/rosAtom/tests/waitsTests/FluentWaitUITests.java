package rosAtom.tests.waitsTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import rosAtom.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FluentWaitUITests extends BaseTest {

    private final By buttonJournalists = By.xpath("//li/a[@href=\"/journalist/\"]");
    private final By feedbackFormTitle = By.xpath("//h2[contains(text(),'Форма обратной связи')]");

    @Test
    @DisplayName("Проверка раздела 'Журналистам'. Используем настраиваемые ожидания FluentWait.")
    public void openPageJournalistsFluentWaitTest() {

        // Настройка FluentWait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        // Ожидаем появления и кликаем по ссылке "Журналистам"
        WebElement journalistsLink = wait.until(driver -> {
            WebElement element = driver.findElement(buttonJournalists);
            return element.isDisplayed() ? element : null;
        });
        journalistsLink.click();

        // Ожидаем true если после загрузки страницы появилась заголовок форма обратной связи
        boolean isFormDisplayed = wait.until(driver -> driver.findElement(feedbackFormTitle).isDisplayed());
        // Проверяем отображение формы обратной связи
        assertTrue(isFormDisplayed, "Форма обратной связи не отображается");
    }
}
