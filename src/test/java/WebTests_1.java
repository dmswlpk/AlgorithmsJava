import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
        Thread.sleep(1000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        sumbitLngsBtnk.click();
        Thread.sleep(1000);

        WebElement findErrorMsg = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        String actualResult = findErrorMsg.getText();
        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
    @Test
    public void Test_Case_11_13_confirmTheText() throws InterruptedException{
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form" +
                " (especially the language name and description), the easier it will be for us and the faster your " +
                "language will show up on this page. We don't have the time to mess around with fixing your " +
                "descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();

        WebElement confirmText = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li[position()=1]"));

        String actualResult = confirmText.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void Test_Case_11_14_confirmBrowseLnggsTableContain_1_2() throws InterruptedException{
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String[] expectedResult = {"Language", "Author"};

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement browseLnggs = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));

        browseLnggs.click();

        WebElement table1_Names = driver.findElement(
        By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[text()='Language']"));
        WebElement table2_Names = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/th[text()='Author']"));

        String[] actualResult = {table1_Names.getText(), table2_Names.getText()};

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    public void Test_Case_11_15_confirmMainMenuNoNewComments() throws InterruptedException {



    }
}

