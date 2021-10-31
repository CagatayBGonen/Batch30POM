package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C05_CHNegativeCongifTest extends TestBase {
    @Test
    public void negativelogintestConfig(){
        driver.get(ConfigurationReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHInvalidUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHInvalidPassword"));
        concortHotelPage.submitBttn.click();
        Assert.assertTrue(concortHotelPage.resultBox.isDisplayed(),"negative login test failed");
    }
}
