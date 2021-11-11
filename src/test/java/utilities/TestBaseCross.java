package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {

    //abstract yapmak sart degil ama bu sayede bu classtan obj olusturulmasini onluyoruz.
    protected WebDriver driver;
    //extends ile inherit ettigimiz icin, protected kullanabiliriz. (olablidigince dar tutmaya calismaliyiz)
    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional String browser){
        driver = DriverCross.getDriver(browser);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
