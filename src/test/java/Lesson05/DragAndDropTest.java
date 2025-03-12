package Lesson05;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

//    2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
// - Откройте https://the-internet.herokuapp.com/drag_and_drop
// - Перенесите прямоугольник А на место В
// - Проверьте, что прямоугольники действительно поменялись
// - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions().


public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x800";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void actionsDragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement squareA = $("#column-a");
        SelenideElement squareB = $("#column-b");
        squareA.shouldBe(visible);
        squareB.shouldBe(visible);
        actions().clickAndHold(squareA).moveToElement(squareB).release().perform();
        squareA.shouldHave(text("B"));
        squareB.shouldHave(text("A"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
