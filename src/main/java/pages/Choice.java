package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
public class Choice extends GeneralPanel{
    WebDriver driver;
    private String choice;

    @FindBy(xpath = "//*[contains(text(),'Перейти ко всем фильтрам')]")
    private WebElement allFiltersElement;

    @FindBy(xpath = "//*[@role = 'listbox']")
    private WebElement sortAmount;

    @FindBy(xpath = "//span[@class ='select__text' and contains(text(),'Показывать по 12')]")
    private WebElement choice12;

    @FindBy(xpath = "//div[@class= 'n-snippet-card2__title']")
    private List<WebElement> devicesTV;

    @FindBy(xpath = "//div[@class= 'n-snippet-cell2__title']")
    private List<WebElement> devicesHeadphones;

    @FindBy(xpath = "//*[@class = 'title title_size_28 title_bold_yes']")
    private WebElement resultSearch;

    public Choice(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public AllFilters clickAllFilters(){
        allFiltersElement.click();
        return new AllFilters(driver);
    }

    public Choice choose12(){
        sortAmount.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(choice12));
        choice12.click();
        return this;
    }

    public Choice checkAmountDevices(String technicalType){
        if(technicalType.equals("Телевизоры")) {
            if (devicesTV.size() != 12)
                checkAmountDevices(technicalType);
            int actualAmount = devicesTV.size();
            Assert.assertEquals("Не совпадает кол-во телевизоров", 12, actualAmount);
        }
        if(technicalType.equals("Наушники")) {
            if (devicesHeadphones.size() != 12)
                checkAmountDevices(technicalType);
            int actualAmount = devicesHeadphones.size();
            Assert.assertEquals("Не совпадает кол-во телевизоров", 12, actualAmount);
        }
        return this;
    }

    public void searchChoiceElementAndCheck(int position, String technicalType){
        WebElement choiceDevice = null;
        if(technicalType.equals("Телевизоры")){
            choiceDevice = devicesTV.get(position - 1);
        }
        if(technicalType.equals("Наушники")) {
            choiceDevice = devicesHeadphones.get(position - 1);
        }
        String nameChoiceDevice = choiceDevice.getText();
        search.sendKeys(choiceDevice.getText());
        find.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(resultSearch));
        String actualName = resultSearch.getText();
        Assert.assertEquals("Имена не совпадают",nameChoiceDevice,actualName);
    }

}
