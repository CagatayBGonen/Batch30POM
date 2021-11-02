package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages02 extends TestBase {
    //amazon
    // dropdown menuden book secin
    // java icin arama
    // bulunan sonuc yazisi yazdirin
    // ilk üründe java gectigini test edin
    @Test
    public void javaSearchTest() {
        driver.get("https://www.amazon.com/");
        AmazonPage amazonPage = new AmazonPage(driver);
        Select select = new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Books");
        amazonPage.seachBox.sendKeys("Java", Keys.ENTER);
        System.out.println(amazonPage.resultText.getText());

    }
}