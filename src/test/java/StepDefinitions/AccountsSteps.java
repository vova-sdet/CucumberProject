package StepDefinitions;

import Pages.AccountsPage;
import Pages.HomePage;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsSteps {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);
    AccountsPage accountsPage = new AccountsPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("the user clicks the Accounts tab")
    public void the_user_clicks_the_Accounts_tab() throws InterruptedException {
        homePage.accountsTab.click();
    }

    @Then("the user clicks the Create Account button")
    public void the_user_clicks_the_Create_Account_button() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(accountsPage.createAccountButton));
        accountsPage.createAccountButton.click();
    }

    @Then("the user enters {string}, {string}, {string}, {string} and saves new account")
    public void the_user_enters_and_saves_new_account(String name, String website, String accType, String country) {
        accountsPage.nameBox.sendKeys(name);
        accountsPage.websiteBox.sendKeys(website);
        Select select = new Select(accountsPage.selectAccType);
        select.selectByVisibleText(accType);
        accountsPage.countryBox.sendKeys(country);

        accountsPage.saveButton.click();
    }

    @Then("the user validate the new account details {string}, {string}, {string}, {string} are matching")
    public void the_user_validate_the_new_account_details_are_matching(String name, String website, String accType, String country) {

        try {
            if (accountsPage.confirmButton.isDisplayed()) {
                accountsPage.confirmButton.click();
            }
        } catch (NoSuchElementException exception) {

        }

        homePage.accountsTab.click();

        Assert.assertEquals("Name validation: ", name, accountsPage.accountDetails.get(1).getText());
        Assert.assertEquals("website validation: ", website, accountsPage.accountDetails.get(2).getText());
        Assert.assertEquals("Account type validation: ", accType, accountsPage.accountDetails.get(3).getText());
        Assert.assertEquals("Country validation: ", country, accountsPage.accountDetails.get(4).getText());

    }
}
