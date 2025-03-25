package lesson07;

import lesson07.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormWithFakeData extends TestBase {

    PracticeFormPage registrationPage = new PracticeFormPage();
    TestData testData = new TestData();
    String firstName = testData.firstName;
    String lastName = testData.lastName;
    String userEmail = testData.userEmail;
    String gender = testData.gender;
    String userNumber = testData.userNumber;
    String dayOfBirth = testData.dayOfBirth;
    String monthOfBirth = testData.monthOfBirth;
    String yearOfBirth = testData.yearOfBirth;
    String subject = testData.subject;
    String hobbies = testData.hobbies;
    String uploadImage = testData.uploadImage;
    String currentAddress = testData.currentAddress;
    String state = testData.state;
    String city = testData.city;
    @Test
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
