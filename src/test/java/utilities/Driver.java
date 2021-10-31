package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver;
    // driver'i baska classlardan sadece Driver class ismi ile cagırabilmek icin Static yaptik
    // henuz bu driver ile ilgili ayarlar yapmadigim icin baska classlar bunu yanlislikla kullanmasin diye
    // erisimi private yaptik (sadece bu classin kullanimina acik yaptik)

    public static void getDriver(){

    }
}
