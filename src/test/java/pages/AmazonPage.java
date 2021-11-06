package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AmazonPage {

    //bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement seachBox;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultText;
    @FindBy(id = "searchDropdownBox")
    public WebElement dropdownMenu;


}
