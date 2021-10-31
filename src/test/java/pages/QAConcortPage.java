package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QAConcortPage {
    public WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement loginButton;
    @FindBy(id = "UserName")
    public WebElement usernameBox;
    @FindBy(id = "Password")
    public WebElement passwordBox;
    @FindBy(id = "btnSubmit")
    public WebElement submitBttn;
    @FindBy(id = "divMessageResult")
    public WebElement resultBox;
}
