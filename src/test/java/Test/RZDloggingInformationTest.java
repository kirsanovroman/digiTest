package Test;

import Page.RZDHomePage;
import Page.SelectTrainPage;
import org.testng.annotations.Test;

@Test
public class RZDloggingInformationTest extends BaseTestClass {
    public void openHomePage() throws InterruptedException {

        //переход на страницу РЖД
        getRZDHomePage("http://www.rzd.ru/");
        RZDHomePage homePage = new RZDHomePage(driver);
        //выбор маршрута и даты отправления
        SelectTrainPage selectTrainPage=homePage.specifyPath("Москва", "Тула", "23.03.2018");
        //выбор категории купе и нажатие на произвольный вагон для номера поезда из списка
        selectTrainPage.selectCoupeCategoryInTrain("119А");
        //логирование информации о местах в вагоне
        selectTrainPage.logFreePlace();
    }
}
