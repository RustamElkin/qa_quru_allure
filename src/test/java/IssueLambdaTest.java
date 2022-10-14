import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueLambdaTest extends BaseTest {
    public static final String repo = "allure-framework/allure-java";

    @Test
    @DisplayName("Check issue by lambda")
    @Owner("Ryelkin")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void checkIssueTest() {
        step("Open main page", () -> open("https://github.com"));
        step("Search repository" + repo, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repo);
            $(".header-search-input").submit();
        });
        step("Click by link of repository -" + repo, () -> $(linkText(repo)).click());
        step("Click by issue", () -> $("#issues-tab").click());
        step("Check that element #829 is exist on page", () ->
                $(withText("#829")).should(Condition.exist));
    }
}