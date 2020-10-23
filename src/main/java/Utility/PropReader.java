package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {

    public static String getValue(String key){
        String value ;

        File file = new File("./config.properties");

        Properties prop = new Properties();

        FileInputStream fis = null;

        try{
            fis = new FileInputStream(file);

            prop.load(fis);

            value = prop.getProperty(key);
            System.out.println("Value of '" + key + "'is " + value );
            return value;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
