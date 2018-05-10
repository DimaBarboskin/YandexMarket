package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class YandexMarket {
    WebDriver driver;

    @FindBy(xpath = "//li[@data-department = 'Электроника']")
    private WebElement electronics;

    public YandexMarket(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public YandexMarket moveToElectronics(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class = 'n-region-notification__actions-cell']"))));

        WebElement closePanel = driver.findElement(By.xpath("//*[@class = 'n-region-notification__actions-cell']"));
        closePanel.click();

        new Actions(driver).moveToElement(electronics).perform();
        return this;
    }

    public Choice clickTechnicalItem(String technicalType){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + technicalType + "')]"))));

        WebElement elementChoice = driver.findElement(By.xpath("//*[contains(text(),'" + technicalType + "')]"));
        elementChoice.click();

        return new Choice(driver);
    }
}
