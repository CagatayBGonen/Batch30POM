package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C04_AmazonConfig extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("AmazonUrl"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.seachBox.sendKeys("Nutella"+ Keys.ENTER);
        System.out.println(amazonPage.resultText.getText());
        Assert.assertTrue(amazonPage.resultText.getText().contains("Nutella"),"Aranan kelime arama sonuclari yazsinida yok");

    }
}
