package tests.day25;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DataProviderTest {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
    }
}
