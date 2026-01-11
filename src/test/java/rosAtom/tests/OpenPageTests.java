package rosAtom.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rosAtom.BaseTest;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenPageTests extends BaseTest {

    @Test
    @DisplayName("Открытие стартовой страницы Росатом")
    public void openStartPageTest() {
        try {
            sleep(5000);

            String pageTitle = driver.getTitle();
            assertTrue(pageTitle.contains("Росатом"),
                    "Заголовок страницы должен содержать строку 'Росатом'. Актуальный заголовок: " + pageTitle);
        } catch (Exception e) {
            throw new AssertionError("Test failed: " + e.getMessage(), e);
        }
    }
}
