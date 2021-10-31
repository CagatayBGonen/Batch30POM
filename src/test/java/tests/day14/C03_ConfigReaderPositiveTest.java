package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C03_ConfigReaderPositiveTest  extends TestBase {
        /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
		http://qa-environment.koalaresorthotels.com adresine git
		login butonuna bas
	test data username: manager ,
	test data password : Manager1!
	Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */
    @Test
    public void positiveCongfigLoginTest(){
        driver.get(ConfigurationReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        concortHotelPage.submitBttn.click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.getProperty("CHAdminUserPageUrl"),"admin olarak login edilmedi");
    }
}
