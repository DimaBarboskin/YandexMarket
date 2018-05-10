package application;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class TeatBase {
    protected static WebDriver driver;
    private static String firsUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        firsUrl = properties.getProperty("first.url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(firsUrl);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
