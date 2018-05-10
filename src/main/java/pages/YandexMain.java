package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class YandexMain {
    WebDriver driver;

    @FindBy(xpath = "//*[@data-statlog = 'tabs.market']")
    private WebElement yandexMarket;

    public YandexMain(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public YandexMarket clickMarket(){
        yandexMarket.click();
        return new YandexMarket(driver);
    }
}
