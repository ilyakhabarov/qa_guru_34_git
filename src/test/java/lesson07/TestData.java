package lesson07;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker faker;

    public final String firstName,
            lastName,
            userEmail,
            gender,
            userNumber,
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            subject,
            hobbies,
            uploadImage,
            currentAddress,
            state,
            city;

    public TestData() {
        this.faker = new Faker(new Locale("en-GB"));

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.userEmail = faker.internet().emailAddress();
        this.gender = faker.demographic().sex();
        this.userNumber = faker.phoneNumber().subscriberNumber(10);
        this.dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 29));
        this.monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        this.yearOfBirth = String.valueOf(faker.number().numberBetween(1925, 2024));
        this.subject = faker.options().option("Maths", "English", "Physics", "Chemistry", "Biology",
                "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies",
                "History", "Civics");
        this.hobbies = faker.options().option("Sports", "Reading", "Music");
        this.uploadImage = faker.options().option("images/qa_guru_logo.png");
        this.currentAddress = faker.address().fullAddress();
        this.state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.city = randomCity(this.state);
    }

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
