package Lesson07;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 29)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1925, 2024)),
            subject = faker.options().option("Maths", "English", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            uploadImage = faker.options().option("images/qa_guru_logo.png"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = randomCity(state);

    public static String randomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jodhpur");
            default -> "";
        };
    }
}
