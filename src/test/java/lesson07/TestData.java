package lesson07;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1990, 2023));
    public String subject = faker.options().option("Social Studies", "Arts", "Chemistry");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String uploadImage = faker.options().option("images/qa_guru_logo.png");
    public String currentAddress = faker.address().streetAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = randomCity(state);


    public String randomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jodhpur");
            default -> "";
        };
    }
}
