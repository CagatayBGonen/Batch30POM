package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PositiveLoginTest extends TestBaseRapor {
    @Test
    public void positiveLoginTest(){
        extentTest=extentReports.createTest("positive login test","siteye basarili girme testi");
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        extentTest.info("Concort Hotel sitesine gidildi");
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        extentTest.info("login tusuna basildi");
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        qaConcortPage.submitBttn.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigurationReader.getProperty("CHQAAdminUserPageUrl"),"admin sayfasina gitmedi");
        Driver.closeDriver();
    }
}
