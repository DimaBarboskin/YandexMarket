package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;
    private TestProperties(){
        try {
            properties.load(new FileInputStream(new File("./Application.properties")));
        } catch (IOException e) {
            System.err.println("No file");
        }
    }
    public static TestProperties getInstance(){
        if(INSTANCE == null)
            INSTANCE = new TestProperties();
        return INSTANCE;
    }
    public Properties getProperties(){
        return properties;
    }
}
