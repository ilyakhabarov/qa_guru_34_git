package lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest {
    private static final String REPO = "selenide/selenide";

    @Test
    @Disabled
    public void annotatedStepsIssueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPO);
        steps.clickOnRepositoryLink(REPO);
        steps.openIssuesTab();
        steps.shouldSeeIssueTab();
    }
}
