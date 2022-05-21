import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_11_1_Check_TheTitle {
    @Test
    public void TestCase_11_1_testTheTitle() throws InterruptedException{

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement rightAngleLogo = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = rightAngleLogo.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
}


