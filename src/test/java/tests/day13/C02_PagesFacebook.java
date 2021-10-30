package tests.day13;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {
    /*
    facebook login sayfasina gidin
    Kullanıcı adi : techproed
    sifre : 12345
    giris yapilamadigini test edin
     */
    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);
        FacebookPage facebookPage = new FacebookPage(driver);
        actions.click(facebookPage.emailBox)
                .sendKeys("techproed")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
