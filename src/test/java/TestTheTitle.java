import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTheTitle {
    @Test
    public void testTheTitle() throws InterruptedException{

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/ChromeDriver/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver,"C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement rightAngleLogo = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = rightAngleLogo.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
}


