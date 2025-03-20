package Lesson06.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxFormPage {

    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            userAddressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public TextBoxFormPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxFormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxFormPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxFormPage setAddress(String value) {
        userAddressInput.setValue(value);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkValidInput(String fullName, String userEmail, String currentAddress) {
        $("#output #name").shouldHave(text(fullName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
    }
}