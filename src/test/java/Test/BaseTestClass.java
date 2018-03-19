package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class BaseTestClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        System.out.println("initialization WebDriver");
//        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void TearsDown() {
        driver.quit();
        System.out.println("quit WebDriver instance");
    }

    public void getRZDHomePage(String homePageURL) {
        driver.get(homePageURL);

    }
}
