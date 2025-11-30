package utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfigProperties {

    static Properties prop;
    static {
//        try(FileInputStream fis = new FileInputStream("./config.properties")){
//        prop = new Properties();
//        prop.load(fis);
//        }
//        catch (IOException e)
//        {
//            System.out.println(e.getLocalizedMessage());
//        }
        try {
            Reader r = new FileReader("./config.properties");
            prop = new Properties();
            prop.load(r);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    public static String getProperty(String key)
    {
        return prop.getProperty(key);
    }
}
