package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {
    // amazon sayfasina gidip
    // nutella için arama
    // sonuc sayisini yazisi print
    // sonuc yazisinin nutella icerdigini test edin.
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella", Keys.ENTER);
        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultTextElement.getText());
        Assert.assertTrue(resultTextElement.getText().contains("Nutella"),"Nutella icermiyor");
    }
    @Test
    public void testPOM(){
        driver.get("https://www.amazon.com/");
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.seachBox.sendKeys("Nutella"+ Keys.ENTER);
        System.out.println(amazonPage.resultText.getText());
        Assert.assertTrue(amazonPage.resultText.getText().contains("Nutella"),"Nutella icermiyor");
    }
}
