package tests.day19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Report extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest = extentReports.createTest("Nutella Testi","Sonuc Sayisi 1000den az olmali");
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasina gidili");
        amazonPage.seachBox.sendKeys(ConfigurationReader.getProperty("searchProduct"),Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");
        String resultArray[] = amazonPage.resultText.getText().split(" ");
        int resultNum = Integer.parseInt(resultArray[2]);
        extentTest.info("sonuc yazisi integer haline getirildi");
        Assert.assertTrue(resultNum<1000);
        extentTest.pass("sonuc sayisinin 1000 den az oldugu test edildi");
    }
    @Test
    public void test02(){
        extentTest = extentReports.createTest("Samsung Testi","Sonuc Sayisi 1000den az olmali");
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasina gidili");
        amazonPage.seachBox.sendKeys("Samsung",Keys.ENTER);
        extentTest.info("Samsung icin arama yapildi");
        String resultArray[] = amazonPage.resultText.getText().split(" ");
        String resultAdedi = resultArray[3];
        resultAdedi=resultAdedi.replace(",","");
        int resultNum = Integer.parseInt(resultAdedi);
        extentTest.info("sonuc yazisi integer haline getirildi");
        Assert.assertTrue(resultNum<1000);
        extentTest.pass("sonuc sayisinin 1000 den az oldugu test edildi");
    }
    @Test
    public void test03(){
        extentTest=extentReports.createTest("java test","ilk urunde java olmali");
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
        extentTest.info("amazona gidildi");
        Select select = new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Electronics");
        extentTest.info("dropdpowndan electronics secildi");
        amazonPage.seachBox.sendKeys("java",Keys.ENTER);
        extentTest.info("java aratildi");
        String ilkUrunText = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).getText();
        Assert.assertTrue(ilkUrunText.contains("java"));
        extentTest.pass("ilk urun isminde java oldugu test edildi");
    }
}
