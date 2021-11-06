package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ResuableMethods {
    @Test
    public void test01(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilksayfaHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleKumesi = Driver.getDriver().getWindowHandles();

        String ikinciSayfahandle = "";

        for (String each : windowHandleKumesi
             ) {
            if (!each.equals(ikinciSayfahandle)){
                ikinciSayfahandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfahandle);
        System.out.println(Driver.getDriver().getTitle());
        WebElement yeniWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(yeniWindowYaziElementi.isDisplayed(),"yeni window yazisi gorunmedi");
        Driver.closeDriver();
    }
    @Test
    public void test02(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement yeniWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(yeniWindowYaziElementi.isDisplayed(),"yeni window yazisi gorunmedi");
        Driver.closeDriver();
    }
}
