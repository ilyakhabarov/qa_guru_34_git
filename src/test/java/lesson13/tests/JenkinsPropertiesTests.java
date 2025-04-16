package lesson13.tests;

import org.junit.jupiter.api.Test;

public class JenkinsPropertiesTests {

    @Test
    void getJenkinsPropertiesTest() {
        System.out.println("Browser: " + System.getProperty("browser", "chrome"));
        System.out.println("Browser version: " + System.getProperty("browserVersion", "128.0"));
        System.out.println("Browser size: " + System.getProperty("browserSize", "1280x720"));
        System.out.println("Remote URL: " + System.getProperty("remoteUrl"));
    }
}
