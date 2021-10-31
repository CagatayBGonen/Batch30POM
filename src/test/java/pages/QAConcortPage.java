package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class QAConcortPage {
    public WebDriver driver;

    public QAConcortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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
    @FindBy(id = "menuHotels")
    public WebElement menuHotel;
    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelList;
    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelBttn;
    @FindBy(id = "Code")
    public WebElement codeBox;
    @FindBy(id = "Name")
    public WebElement nameBox;
    @FindBy(id = "IDGroup")
    public WebElement idGroupDropdownMenu;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement hotelSavedBox;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okBttn;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBttn;


    public void qaConcortHotelAdminLogin() {
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        qaConcortPage.submitBttn.click();
    }
}
