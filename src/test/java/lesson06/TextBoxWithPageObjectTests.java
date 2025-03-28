package lesson06;

import lesson06.pages.TextBoxFormPage;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectTests extends TestBase{

    String fullName = "Ilya Khabarov";
    String userEmail = "test@test.com";
    String currentAddress = "Moscow, Russia";

    TextBoxFormPage textBoxFormPage = new TextBoxFormPage();

    @Test
    void successFillFormTest() {
        textBoxFormPage.openPage()
                .removeBanner()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setAddress(currentAddress)
                .submitForm();

        textBoxFormPage.checkValidInput(fullName, userEmail, currentAddress);
    }
}
