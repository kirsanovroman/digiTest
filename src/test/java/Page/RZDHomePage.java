package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RZDHomePage extends BasePageClass {
    /**
     * Выбор маршрута и даты отправления
     * @param from
     * @param where
     * @param date
     * @return
     */
    public SelectTrainPage specifyPath(String from, String where, String date) throws InterruptedException {
        getElementByXpath("//input[@placeholder='Откуда']").sendKeys(from);
        getElementByXpath("//input[@title='Куда']").sendKeys(where);
        getElementByXpath("//input[@title='Дата']").clear();
        getElementByXpath("//input[@title='Дата']").sendKeys(date+ Keys.ENTER);
//        getElementByXpath("//input[@id='Submit']").click();
//        Thread.sleep(3000);
        clickFindButton();
        return new SelectTrainPage(driver);
    }

    /**
     * Нажатие на кнопку найти
     */
    public void clickFindButton() {
        WebDriverWait myWaitVar = new WebDriverWait(driver,5);
        WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Submit']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);

    }

    public RZDHomePage(WebDriver driver) {
        super(driver);
    }



}
