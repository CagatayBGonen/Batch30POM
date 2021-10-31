package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTest {
    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        qaConcortPage.submitBttn.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigurationReader.getProperty("CHQAAdminUserPageUrl"),"admin sayfasina gitmedi");
        Driver.closeDriver();
    }
}
