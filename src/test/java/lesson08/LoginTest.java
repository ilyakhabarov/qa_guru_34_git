package lesson08;

import lesson08.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LoginTest extends TestBase {

    private final LoginPage loginPage = new LoginPage();

    // 1. Параметризация с @CsvSource
    @ParameterizedTest (name = "CSV: Авторизация с логином {0} и паролем {1}")
    @CsvSource({
            "validUser, validPassword",
            "invalidUser, invalidPassword",
            "emptyUser, emptyPassword"
    })
    void testLoginWithCsvSource(String username, String password) {
        loginPage.openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLogin()
                .checkLoginResult();
    }

    // 2. Параметризация с @CsvFileSource (из файла CSV)
    @ParameterizedTest (name = "CSV-file: Авторизация с логином {0} и паролем {1}")
    @CsvFileSource(resources = "/loginData.csv", numLinesToSkip = 1)
    void testLoginWithCsvFile(String username, String password) {
        loginPage.openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLogin()
                .checkLoginResult();

    }

    //3. Параметризация с @MethodSource (из метода)
    static Stream<Arguments> loginDataProvider() {
        return Stream.of(
                Arguments.of("validUser", "validPassword"),
                Arguments.of("invalidUser", "invalidPassword")
        );
    }

    @ParameterizedTest (name = "Stream: Авторизация с логином {0} и паролем {1}")
    @MethodSource("loginDataProvider")
    void testLoginWithMethodSource(String username, String password) {
        loginPage.openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLogin()
                .checkLoginResult();
    }
}