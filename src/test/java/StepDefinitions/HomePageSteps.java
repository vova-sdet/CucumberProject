package StepDefinitions;

import Pages.HomePage;
import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePageSteps {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("the user goes to espoCRM page and login")
    public void the_user_goes_to_espoCRM_page_and_login() {
        driver.get(ConfigReader.getProperties("espoUrl"));

        try {
            if (homePage.loginButton.isDisplayed()) {
                homePage.loginButton.click();
            }
        } catch (NoSuchElementException exception) {

        }
    }

    @Then("the user validate functions names")
    public void the_user_validate_functions_names(DataTable dataTable) {
        List<String> expectedFunctionNames = dataTable.asList();
        List<String> actualFunctionNames = BrowserUtils.getTextOfElements(homePage.visibleFunctionsNames);

        for (int i = 0; i < expectedFunctionNames.size(); i++) {
            Assert.assertEquals(expectedFunctionNames.get(i), actualFunctionNames.get(i));
        }
    }
}
