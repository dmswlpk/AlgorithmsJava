import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_11_06_ConfirmNames {
    @Test
    public void confirmNames() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/ChromeDriver/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Oliver Schade".concat("Gregor Scheithauer".concat("Stefan Scheler"));

        System.setProperty(chromeDriver, "C://chromeDriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        menuTeam.click();

        WebElement creatorNames = driver.findElement(
                By.xpath("//body/div[@id='wrap']//div[@id='main']/h3[Oliver Schade]"));
        String actualResult = creatorNames.getText();

        Assert.assertSame(actualResult,expectedResult);

        driver.quit();


    }
}
