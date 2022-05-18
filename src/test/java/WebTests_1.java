import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WebTests_1 {
    @Test
    public void TestCase_11_11_Check_Submit_Language_Error() throws AWTException {

        String chromeDriver = "webdriver.chrome.driver";
        String drivePath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        Boolean expectedResult = true;

        System.setProperty(chromeDriver, drivePath);
        WebDriver driver = new ChromeDriver();


        driver.get(url);
        driver.manage().window().maximize();

        WebElement submitLanguageBTNKError = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        submitLanguageBTNKError.click();

        WebElement openErrorPage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        Boolean actualResult = openErrorPage.isDisplayed();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_12_Check_Submit_Language_Error() throws InterruptedException, AWTException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String  expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();

        WebElement sumbitLngsBtnk = driver.findElement(
              By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );
        Thread.sleep(1500);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        sumbitLngsBtnk.click();

        WebElement findErrorMsg = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        String actualResult = findErrorMsg.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
}

