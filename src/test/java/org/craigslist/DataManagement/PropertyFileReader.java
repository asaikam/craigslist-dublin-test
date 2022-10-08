package org.craigslist.DataManagement;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

    public static Properties prop;

    public static Properties fn_ReadPropertyFile() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/resources/Config.Properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}

