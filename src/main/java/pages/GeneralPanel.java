package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 10.05.2018.
 */
public class GeneralPanel {
    WebDriver driver;

    @FindBy(xpath = "//*[@name= 'text']")
    protected WebElement search;

    @FindBy(xpath = "//*[@class = 'search2__button']")
    protected WebElement find;

    public GeneralPanel(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
