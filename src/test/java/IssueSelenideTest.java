import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueSelenideTest extends BaseTest {

    @DisplayName("Check issue simple selenide")
    @Owner("Ryelkin")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    @Test
    public void checkIssueTest() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure-framework/allure-java");
        $(".header-search-input").submit();

        $(linkText("allure-framework/allure-java")).click();
        $("#issues-tab").click();
        $(withText("#829")).should(Condition.exist);
    }
}
