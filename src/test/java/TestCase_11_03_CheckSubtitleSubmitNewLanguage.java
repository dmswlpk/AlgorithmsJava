import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class TestCase_11_03_CheckSubtitleSubmitNewLanguage {

    public void checkSubtitleSubmitNewLanguage() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C://chromeDriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        menuSubmitNewLanguage.click();

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = submitNewLanguage.getText();
        Assert.assertEquals(actualResult.toLowerCase(),expectedResult.toLowerCase());

        driver.quit();
    }
}
