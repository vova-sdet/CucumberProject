package StepDefinitions;

import Pages.HomePage;
import Pages.UsersPage;
import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UsersPageSteps {

    WebDriver driver = Driver.getDriver();
    UsersPage usersPage = new UsersPage(driver);
    HomePage homePage = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @When("the user clicks the three dot button")
    public void the_user_clicks_the_three_dot_button() {
        wait.until(ExpectedConditions.visibilityOf(homePage.moreFunctions));
        homePage.moreFunctions.click();
    }

    @Then("the user clicks the Users tab")
    public void the_user_clicks_the_Users_tab() {
        homePage.usersTab.click();
    }

    @Then("the user should validate the Names and Emails are matching the with the provided table")
    public void the_user_should_validate_the_Names_and_Emails_are_matching_the_with_the_provided_table(DataTable userDetails) throws InterruptedException {

        List<String> expectedUsersDetails = userDetails.asList();
        Thread.sleep(2000);

            for(int i = 0; i < expectedUsersDetails.size(); i++) {
                String expectedDetail = expectedUsersDetails.get(i);
                // wait.until(ExpectedConditions.visibilityOf(usersPage.usersDetails.get(i)));
                String actualDetail = usersPage.usersDetails.get(i).getText();
                Assert.assertEquals(expectedDetail, actualDetail);
            }
    }
}
