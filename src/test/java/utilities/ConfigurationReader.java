package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // properties olusturacagiz
    static Properties properties;
    // bu classin amaci configuration.properties dosyasini okumak
    // ve aradaki key value ikililerini kullanarak istedigimiz key'e ait valuyu bize getirmek
    //
    static{
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // test class'larindan configReader classina ulasip yukaridaki islemleri
    // yapmamizi saglıyacak bir method olusturacagiz.
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
    }
}
