package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;




import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        Path tempProfile = Files.createTempDirectory("chrome-profile");
        options.addArguments("user-data-dir=" + tempProfile.toAbsolutePath().toString());

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
