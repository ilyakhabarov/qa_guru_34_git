package Lesson06;

import Lesson06.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectTests extends TestBase {

    String firstName = "Ilya";
    String lastName = "Khabarov";
    String userEmail = "test@test.com";
    String gender = "Male";
    String userNumber = "1234567890";
    String dayOfBirth = "06";
    String monthOfBirth = "May";
    String yearOfBirth = "1994";
    String subject = "Computer Science";
    String hobbies = "Sports";
    String uploadImage = "images/qa_guru_logo.png";
    String currentAddress = "Moscow, Russia";
    String state = "Rajasthan";
    String city = "Jaipur";

    PracticeFormPage registrationPage = new PracticeFormPage();

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(uploadImage)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "qa_guru_logo.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minimalInputDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber("12345")
                .submitForm();

        registrationPage.checkInvalidInput();
    }

}
