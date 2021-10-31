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
    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
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
    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsList;
    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomBttn;
    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdownMenu;
    @FindBy(id = "Price")
    public WebElement priceDropBox;
    @FindBy(xpath = "(//li[@class='credit ui-draggable ui-draggable-handle'])[1]")
    public WebElement dragPrice;
    @FindBy(id = "IDGroupRoomType")
    public WebElement idGroupRoomTypeDropdownMenu;
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelRoomsText;
    @FindBy(id = "IsAvailable")
    public WebElement approvedBox;
    @FindBy(linkText = "Hotelrooms")
    public WebElement HotelRoomsLink;


    public void qaConcortHotelAdminLogin() {
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        qaConcortPage.submitBttn.click();
    }
}
