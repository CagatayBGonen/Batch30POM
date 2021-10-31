package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {
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
    public void positiveLoginTest(){
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.usernameBox.sendKeys("manager");
        concortHotelPage.passwordBox.sendKeys("Manager1!");
        concortHotelPage.submitBttn.click();
        String expectedUserAdminURL = "https://www.concorthotel.com/Admin/UserAdmin";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUserAdminURL,"Admin sayfasina gidilmedi");
    }
}
