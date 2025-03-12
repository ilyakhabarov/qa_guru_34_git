package Lesson4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x800";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void testSoftAssertionsPage() {
//        Откройте страницу Selenide в Github
//        Перейдите в раздел Wiki проекта
//        Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//        Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

        // открыть главную страницу
        open("https://github.com/");

        // ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        // кликнуть на первый репозиторий из списка найденых
        $$("[data-testid='results-list']").first().$("a").click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave((text("selenide / selenide")));

        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        // проверка: в списке страниц (Pages) есть страница SoftAssertions, переход в раздел
        $$("ul li a").findBy(text("Soft Assertions")).click();

        // проверка: внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text(
                """
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }"""));
    }
}