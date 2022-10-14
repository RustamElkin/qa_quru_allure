import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueAnnotatedStepTest extends BaseTest {

    String repo = "allure-framework/allure-java";
    String issue = "#829";

    @Test
    @DisplayName("Check issue by steps")
    @Owner("Ryelkin")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(repo);
        steps.clickOnRepositoryLink(repo);
        steps.checkShouldSeeIssueWithNumber(issue);
        steps.takeScreenshot();
    }
}
