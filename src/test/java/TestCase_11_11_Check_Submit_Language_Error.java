import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestCase_11_11_Check_Submit_Language_Error {
    @Test
    public void testCheckSubmitLanguageBTNKError() throws AWTException {

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
                     "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"));

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        submitLanguageBTNKError.click();

        WebElement openErrorPage = driver.findElement(
        By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        Boolean actualResult = openErrorPage.isDisplayed();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }



}



