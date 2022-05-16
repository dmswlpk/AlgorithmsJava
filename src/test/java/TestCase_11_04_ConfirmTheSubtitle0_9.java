import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_11_04_ConfirmTheSubtitle0_9 {
    @Test
    public void testConfirmTheSubtitle0_9()throws InterruptedException{

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver,"C://chromeDriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubtitle0_9 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));
        String actualResult = menuSubtitle0_9.getText();
        Thread.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        //driver.quit();
    }
}
