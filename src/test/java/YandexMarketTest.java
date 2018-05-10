import application.TeatBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.YandexMain;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Rogoza Dimity on 09.05.2018.
 */
@RunWith(Parameterized.class)
public class YandexMarketTest extends TeatBase {

    @Parameterized.Parameter()
    public String technicalType;

    @Parameterized.Parameter(1)
    public int choiceItem;

    @Parameterized.Parameter(2)
    public String producer1;

    @Parameterized.Parameter(3)
    public String producer2;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"Телевизоры",1,"LG","Samsung"}, {"Наушники",4,"Sennheiser",null}});
    }

    @Test
    public void Test1(){
    new YandexMain(driver).clickMarket()
            .moveToElectronics()
            .clickTechnicalItem(technicalType)
            .clickAllFilters()
            .setBeginningPrice()
            .chooseProducer(producer1,producer2)
            .showItems()
            .choose12()
            .checkAmountDevices(technicalType)
            .searchChoiceElementAndCheck(choiceItem,technicalType);
    }
}
