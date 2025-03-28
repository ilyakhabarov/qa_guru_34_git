package lesson08.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement usernameInput = $("#userName");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login");
    private final SelenideElement outputResult = $("#output");

    public LoginPage openPage() {
        open("/login");
        $(".text-center").shouldHave(text("Login"));
        return this;
    }

    public LoginPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public LoginPage checkLoginResult(){
        outputResult.shouldHave(text("Invalid username or password!"));
        return this;
    }
}