package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {

    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-action='create']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@autocomplete='espo-name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@data-name='website']")
    public WebElement websiteBox;

    @FindBy(xpath = "//div[@data-name='type']//select[@class='form-control main-element']")
    public WebElement selectAccType;

    @FindBy(xpath = "//div[@data-name='billingAddress']//input[@autocomplete='espo-country']")
    public WebElement countryBox;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    public WebElement confirmButton;

    @FindBy(xpath = "//table//tbody//tr[1]//td")
    public List<WebElement> accountDetails;
}
