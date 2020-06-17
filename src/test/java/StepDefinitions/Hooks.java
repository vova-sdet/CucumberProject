package StepDefinitions;

import Pages.HomePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);

    @Before
    public void goToPage() {

    }
}
