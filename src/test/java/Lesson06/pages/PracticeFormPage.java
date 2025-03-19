package Lesson06.pages;

import Lesson06.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSelect = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            pictureSelect = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            stateAndCitySelect = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderSelect.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesSelect.$(byText(value)).scrollTo().click();
        return this;
    }

    public PracticeFormPage setPicture(String value) {
        pictureSelect.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        userAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        $("#state").click();
        stateAndCitySelect.$(byText(state)).click();
        $("#city").click();
        stateAndCitySelect.$(byText(city)).click();
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public void checkInvalidInput() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}

