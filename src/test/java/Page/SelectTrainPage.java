package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectTrainPage extends BasePageClass {
    public SelectTrainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор категории "Купе" для конкретного поезда
     * @param numberTrain
     * @throws InterruptedException
     */
    public void selectCoupeCategoryInTrain(String numberTrain) throws InterruptedException {
        Thread.sleep(3000);
        getElementByXpath("//div[@class='route-item__purpose__direct'][.//span[@class='route-trnum'][text()='"+numberTrain+"']]//div[contains(text(),'Купе')]").click();
        getRailwayCarriageInformationVidget("//div[@class='route-item__purpose__direct'][.//span[@class='route-trnum'][text()='" + numberTrain + "']]//following-sibling::div[@class='j-cars-box']");
        getElementByXpath("//div[@class='route-item__purpose__direct'][.//span[@class='route-trnum'][text()='" + numberTrain + "']]//following-sibling::div[@class='j-cars-box']//a[span[text()='вагон']]").click();

    }

    /**
     * Ожидание появления виджета с информацией о вагоне
     * @param xPath
     * @return
     */
    public WebElement getRailwayCarriageInformationVidget(String xPath){
        WebElement dynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        return dynamicElement;
    }

    /**
     * Логирование информации о местах в вагоне
     */
    public void logFreePlace() {
        List occupList=driver.findElements(By.cssSelector("g.s-cell.s-occup"));
        List allPlaceList=driver.findElements(By.cssSelector("g.s-cell.s-type-seat"));
        int freePlace = allPlaceList.size() - occupList.size();
        System.out.println("Количество мест в вагоне:"+allPlaceList.size());
        System.out.println("Количество занятых мест в вагоне:"+occupList.size());
        System.out.println("Количество свободных мест в вагоне:"+(allPlaceList.size()-occupList.size()));

    }
}
