package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_E2ETest {
    /*
    1. Tests packagenin altına class olusturun: D17_CreateHotel
2. Bir metod olusturun: createHotel
3. http://qa-environment.koalaresorthotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
	a. Username : manager
	b. Password  : Manager1!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.

     */
    @Test
    public void test() throws InterruptedException {
        Faker faker = new Faker();
        QAConcortPage  qaConcortPage = new QAConcortPage();
        qaConcortPage.qaConcortHotelAdminLogin();
        Thread.sleep(1000);
        qaConcortPage.menuHotel.click();
        Thread.sleep(1000);
        qaConcortPage.hotelList.click();
        qaConcortPage.addHotelBttn.click();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(qaConcortPage.codeBox)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .perform();
        Select select = new Select(qaConcortPage.idGroupDropdownMenu);
        select.selectByIndex(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        qaConcortPage.saveBttn.click();
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.hotelSavedBox.isDisplayed(),"save text gozukmuyor");
        qaConcortPage.okBttn.click();
        Driver.closeDriver();
    }
}
