package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class AllFilters {
    WebDriver driver;

    @FindBy(xpath = "//*[@name='glf-pricefrom-var']")
    private WebElement lowestPrice;

    @FindBy(xpath = "//*[@class = 'button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")
    private WebElement showingItems;

    public AllFilters(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public AllFilters setBeginningPrice(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(lowestPrice));
        lowestPrice.sendKeys("20000");
        return this;
    }

    public AllFilters chooseProducer(String producer, String producer1){
        if(producer != null){
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + producer + "')]"))));
            WebElement producerChoice = driver.findElement(By.xpath("//*[contains(text(),'" + producer + "')]"));
            producerChoice.click();
        }
        if (producer1!= null) {
            WebDriverWait wait1 = new WebDriverWait(driver, 5);
            wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + producer1 + "')]"))));
            WebElement producerChoice1 = driver.findElement(By.xpath("//*[contains(text(),'" + producer1 + "')]"));
            producerChoice1.click();
        }
        return this;
    }

    public AllFilters chooseProducer(String producer){
        WebElement producerCoice = driver.findElement(By.xpath("//*[contains(text(),'" + producer + "')]"));
        producerCoice.click();
        return this;
    }

    public Choice showItems(){
        showingItems.click();
        return new Choice(driver);
    }
}
