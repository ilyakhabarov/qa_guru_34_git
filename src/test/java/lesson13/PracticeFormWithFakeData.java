package lesson13;

import lesson13.pages.PracticeFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PracticeFormWithFakeData extends TestBase {

    PracticeFormPage registrationPage = new PracticeFormPage();
    TestData testData = new TestData();

    String firstName = testData.firstName,
            lastName = testData.lastName,
            userEmail = testData.userEmail,
            gender = testData.gender,
            userNumber = testData.userNumber,
            dayOfBirth = testData.dayOfBirth,
            monthOfBirth = testData.monthOfBirth,
            yearOfBirth = testData.yearOfBirth,
            subject = testData.subject,
            hobbies = testData.hobbies,
            uploadImage = testData.uploadImage,
            currentAddress = testData.currentAddress,
            state = testData.state,
            city = testData.city;

    @Test
    @Tag("demoqa_lesson13")
    void successRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
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
    @Tag("demoqa_lesson13")
    void minimalInputDataTest() {
        registrationPage.openPage()
                .removeBanner()
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
    @Tag("demoqa_lesson13")
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber("12345")
                .submitForm();

        registrationPage.checkInvalidInput();
    }
}
