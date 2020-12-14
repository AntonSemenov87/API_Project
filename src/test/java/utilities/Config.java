package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Configuration Reader class

public class Config {

    private static Properties properties = new Properties();

    // to load info into Object
    static {
       String path = "configuration.properties";

       try {
           FileInputStream file = new FileInputStream(path);
           properties.load(file);
           file.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    // method for getProperty
    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }
}
