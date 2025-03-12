package Lesson05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideMenuTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x800";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void menuBrowsingTest() {
//        На главной странице GitHub выберите: Меню -> Solutions -> Enterprize (с помощью команды hover для Solutions).
//        Убедитесь, что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.").
        open("https://github.com/");
        $(".HeaderMenu-nav").find(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
