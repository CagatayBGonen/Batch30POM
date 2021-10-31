package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_DriverClassUsage {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("FacebookUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("CHUrl"));

        // Driver driver = new Driver();
        // Driver classindan obj uretilmemesini istedigimiz icin Driver classini
        // SINGLETON yapiyoruz
        // access modifier'i private seciyoruz

        Driver.closeDriver();
    }
}
