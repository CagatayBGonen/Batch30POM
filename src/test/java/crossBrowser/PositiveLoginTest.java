package crossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QAConcortPage;
import utilities.*;

public class PositiveLoginTest extends TestBaseCross {
    @Test
    public void positiveLoginTest() throws InterruptedException {
        //Cross borwser testte, test base classina geri donuyoruz
        //cunku @Parameters annotations kullanmak icin.
        //dolayisiyla Driver.getDriver() methodu ve pages sayfalarindaki locaterlari kullanamayiz

        driver.get(ConfigurationReader.getProperty("CHQAUrl"));
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        Thread.sleep(1000);
        concortHotelPage.loginButton.click();
        Thread.sleep(1000);
        concortHotelPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        Thread.sleep(1000);
        concortHotelPage.submitBttn.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.getProperty("CHQAAdminUserPageUrl"),"admin sayfasina gitmedi");
    }
}
