package rosAtom;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rosAtom.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplicitlyWaitTests extends BaseTest {
    @Test
    public void testOpenPage() {
        try {
            // Открытие страницы
            driver.get(baseUrl);
            
            // Ожидание загрузки страницы
            wait.until(ExpectedConditions.titleContains("Росатом"));
            
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
