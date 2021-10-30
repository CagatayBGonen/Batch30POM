package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
    WebDriver driver;
    public FacebookPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public FacebookPage(){

    }
    @FindBy(id = "email")
    public WebElement emailBox;

    public void cookiesMethod(){

    }
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement loginFailedTextBox;
}
