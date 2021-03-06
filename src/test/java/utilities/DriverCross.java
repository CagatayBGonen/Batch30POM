package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class DriverCross {
    private DriverCross() {

    }

    private static WebDriver driver;
    // driver'i baska classlardan sadece Driver class ismi ile cagırabilmek icin Static yaptik
    // henuz bu driver ile ilgili ayarlar yapmadigim icin baska classlar bunu yanlislikla kullanmasin diye
    // erisimi private yaptik (sadece bu classin kullanimina acik yaptik)
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            browser = browser == null ? ConfigurationReader.getProperty("browser") : browser;
            // browser tanimlamayi unutursak, yukaridaki kod garanti olarak islev gorur.
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
