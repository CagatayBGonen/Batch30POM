package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTest {
    /*
    1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
3 Farkli test Methodunda 3 senaryoyu test et
				- yanlisSifre
				- yanlisKulllanici
				- yanlisSifreKullanici
test data yanlis username: manager1 , yanlis password : manager1!
2) http://qa-environment.koalaresorthotels.com adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et

     */
    QAConcortPage qaConcortPage;
    @Test(priority = 1)
    public void negativePasswordTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHvalidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHInvalidPassword"));
        qaConcortPage.submitBttn.click();
        Assert.assertFalse(Driver.getDriver().getCurrentUrl().equals(ConfigurationReader.getProperty("CHQAAdminUserPageUrl")),"hatali sifre ile giris yapildi");

    }
    @Test(priority = 2)
    public void negativeUsernameTest(){
        qaConcortPage = new QAConcortPage();
        qaConcortPage.usernameBox.clear();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHInvalidUsername"));
        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHvalidPassword"));
        qaConcortPage.submitBttn.click();
        Assert.assertFalse(Driver.getDriver().getCurrentUrl().equals(ConfigurationReader.getProperty("CHQAAdminUserPageUrl")),"hatali kullanici adi ile giris yapildi");
    }
    @Test(priority = 3)
    public void negativePasswordUsernameTest(){
        qaConcortPage = new QAConcortPage();
        qaConcortPage.usernameBox.clear();
        qaConcortPage.usernameBox.sendKeys(ConfigurationReader.getProperty("CHInvalidUsername"));
        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigurationReader.getProperty("CHInvalidPassword"));
        qaConcortPage.submitBttn.click();
        Assert.assertFalse(Driver.getDriver().getCurrentUrl().equals(ConfigurationReader.getProperty("CHQAAdminUserPageUrl")),"hatali sifre ve kullanici adi ile giris yapildi");
        Driver.closeDriver();
    }
}
