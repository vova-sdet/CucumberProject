package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btn-login")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav tabs']//li[contains(@class, 'not-in-more tab')]")
    public List<WebElement> visibleFunctionsNames;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement accountsTab;

    @FindBy(id = "nav-more-tabs-dropdown")
    public WebElement moreFunctions;

    @FindBy(partialLinkText = "User")
    public WebElement usersTab;

}
