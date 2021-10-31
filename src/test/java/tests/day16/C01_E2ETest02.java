package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_E2ETest02 {
    /*
     1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
 2. Bir metod olusturun: RoomCreateTest()
 3. http://qa-environment.koalaresorthotels.com adresine gidin.
 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
	a. Username : manager 		b. Password  : Manager1!
 5. Login butonuna tıklayın.
 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
 8. Save butonuna basin.
 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
11. Hotel rooms linkine tıklayın.
12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
     */
    @Test
    public void roomCreateTest() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.qaConcortHotelAdminLogin();
        Faker faker = new Faker();
        qaConcortPage.menuHotel.click();
        qaConcortPage.hotelRoomsList.click();
        qaConcortPage.addHotelRoomBttn.click();
        Select select = new Select(qaConcortPage.idHotelDropdownMenu);
        select.selectByVisibleText(ConfigurationReader.getProperty("CHQAIDHotelselect"));
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(qaConcortPage.codeBox, faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys("paragraf")
                .dragAndDrop(qaConcortPage.dragPrice, qaConcortPage.priceDropBox)
                .perform();
        select = new Select(qaConcortPage.idGroupRoomTypeDropdownMenu);
        select.selectByVisibleText(ConfigurationReader.getProperty("CHQAIDGroupRoomType"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .click(qaConcortPage.saveBttn)
                .perform();
        Thread.sleep(1000);
        Assert.assertTrue(qaConcortPage.resultBox.isDisplayed(), "sonuc yazisi cikmiyor");
        Thread.sleep(1000);
        qaConcortPage.okBttn.click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.HOME)
                .perform();
        Thread.sleep(1000);
        qaConcortPage.HotelRoomsLink.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(qaConcortPage.listOfHotelRoomsText.isDisplayed(), "List of Hotel Rooms texti gorunmuyor");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
