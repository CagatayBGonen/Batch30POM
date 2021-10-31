package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {
    /*
    1 ) Bir Class olustur : NegativeTest
2) Bir test method olustur NegativeLoginTest()
		http://qa-environment.koalaresorthotels.com adresine git
		login butonuna bas
	test data username: manager1 ,
	test data password : manager1!
	Degerleri girildiginde sayfaya girilemedigini test et
     */
    @Test
    public void negativeLoginTest(){
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.usernameBox.sendKeys("manager1");
        concortHotelPage.passwordBox.sendKeys("manager1!");
        concortHotelPage.submitBttn.click();
        Assert.assertTrue(concortHotelPage.resultBox.isDisplayed(),"negative login test failed");
    }
}
